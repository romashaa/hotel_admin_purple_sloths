package com.example.hotel_admin.JUnit_tests;

import com.example.hotel_admin.controller.GuestController;
import com.example.hotel_admin.entity.GuestEntity;
import com.example.hotel_admin.entity.RoomEntity;
import com.example.hotel_admin.repository.CheckInRepository;
import com.example.hotel_admin.repository.GuestRepository;
import com.example.hotel_admin.service.GuestService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class TestGuestController
{
    @Mock
    private GuestRepository testGuestRepository;
    @Mock
    private CheckInRepository testCheckInRepository;
    private GuestService testGuestService;
    private GuestController testGuestController;


    void init()
    {
        MockitoAnnotations.initMocks(this);
        testGuestService = new GuestService(testGuestRepository);
        testGuestController = new GuestController(testGuestService,testCheckInRepository);
    }

    @Test
    public void testCreateGetGuest() throws Exception
    {
        init();
        GuestEntity testGuest = new GuestEntity("name","surname","second name","0845454");

        Mockito.when(testGuestRepository.save(testGuest)).thenReturn(testGuest);
        testGuestController.addGuest(testGuest);

        List<GuestEntity> testList = Arrays.asList(new GuestEntity[]{testGuest});
        Mockito.when(testGuestRepository.findAll()).thenReturn(testList);
        Assert.assertEquals(testList,testGuestController.getGuests());
    }

    @Test
    public void testGetGuestByID() throws Exception
    {
        init();
        GuestEntity testGuest1 = new GuestEntity("name1","surname1","second name1","0845454");
        GuestEntity testGuest2 = new GuestEntity("name2","surname2","second name2","0845454");

        testGuestController.addGuest(testGuest1);
        testGuestController.addGuest(testGuest2);
        List<GuestEntity> testList = Arrays.asList(new GuestEntity[]{testGuest1,testGuest2});

        Mockito.when(testGuestRepository.findById(2)).thenReturn(Optional.of(testGuest2));
        Assert.assertEquals(Optional.of(testGuest2),testGuestController.getGuestById(2));
    }

    @Test
    public void testDeleteAdmin() throws Exception
    {
        init();
        Date date = new Date();
        RoomEntity room = new RoomEntity();
        GuestEntity guest = new GuestEntity();
        GuestEntity testGuest1 = new GuestEntity("name1","surname1","second name1","0845454");
        GuestEntity testGuest2 = new GuestEntity("name2","surname2","second name2","0845454");
        GuestEntity testGuest3 = new GuestEntity("name3","surname3","second name3","0845454");
        GuestEntity testGuest4 = new GuestEntity("name4","surname4","second name4","0845454");

        testGuestController.addGuest(testGuest1);
        testGuestController.addGuest(testGuest2);
        testGuestController.addGuest(testGuest3);
        testGuestController.addGuest(testGuest4);
        List<GuestEntity> testList = Arrays.asList(new GuestEntity[]{testGuest1,testGuest2,testGuest4});

        Mockito.doNothing().when(testGuestRepository).delete(testGuest3);
        Mockito.when(testGuestRepository.findAll()).thenReturn(testList);
        testGuestController.deleteGuest(3);
        Assert.assertEquals(testList,testGuestController.getGuests());
    }
}
