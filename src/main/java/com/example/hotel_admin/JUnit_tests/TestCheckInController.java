package com.example.hotel_admin.JUnit_tests;

import com.example.hotel_admin.controller.CheckInController;
import com.example.hotel_admin.entity.CheckInEntity;
import com.example.hotel_admin.entity.GuestEntity;
import com.example.hotel_admin.entity.RoomEntity;
import com.example.hotel_admin.repository.CheckInRepository;
import com.example.hotel_admin.service.CheckInService;
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
public class TestCheckInController
{
    @Mock
    private CheckInRepository testCheckInRepository;
    private CheckInService testCheckInService;
    private CheckInController testCheckInController;

    void init()
    {
        MockitoAnnotations.initMocks(this);
        testCheckInService = new CheckInService(testCheckInRepository);
        testCheckInController = new CheckInController(testCheckInService);
    }

    @Test
    public void testAddGetCheckIn() throws Exception
    {
        init();
        Date date = new Date();
        RoomEntity room = new RoomEntity();
        GuestEntity guest = new GuestEntity();
        CheckInEntity testEntity = new CheckInEntity(1,date,date,room,guest);

        Mockito.when(testCheckInRepository.save(testEntity)).thenReturn(testEntity);
        testCheckInController.addCheckIn(testEntity);

        List<CheckInEntity> testList = Arrays.asList(new CheckInEntity[]{testEntity});
        Mockito.when(testCheckInRepository.findAll()).thenReturn(testList);
        Assert.assertEquals(testList,testCheckInController.getCheckIns());
    }

    @Test
    public void testGetAdminByID() throws Exception
    {
        init();
        Date date = new Date();
        RoomEntity room = new RoomEntity();
        GuestEntity guest = new GuestEntity();
        CheckInEntity testEntity1 = new CheckInEntity(1,date,date,room,guest);
        CheckInEntity testEntity2 = new CheckInEntity(2,date,date,room,guest);

        testCheckInController.addCheckIn(testEntity1);
        testCheckInController.addCheckIn(testEntity2);
        List<CheckInEntity> testList = Arrays.asList(new CheckInEntity[]{testEntity1,testEntity2});

        Mockito.when(testCheckInRepository.findById(2)).thenReturn(Optional.of(testEntity2));
        Assert.assertEquals(Optional.of(testEntity2),testCheckInController.getCheckInById(2));
    }

    @Test
    public void testDeleteAdmin() throws Exception
    {
        init();
        Date date = new Date();
        RoomEntity room = new RoomEntity();
        GuestEntity guest = new GuestEntity();
        CheckInEntity testEntity1 = new CheckInEntity(1,date,date,room,guest);
        CheckInEntity testEntity2 = new CheckInEntity(2,date,date,room,guest);
        CheckInEntity testEntity3 = new CheckInEntity(3,date,date,room,guest);
        CheckInEntity testEntity4 = new CheckInEntity(4,date,date,room,guest);
        testCheckInController.addCheckIn(testEntity1);
        testCheckInController.addCheckIn(testEntity2);
        testCheckInController.addCheckIn(testEntity3);
        testCheckInController.addCheckIn(testEntity4);
        List<CheckInEntity> testList = Arrays.asList(new CheckInEntity[]{testEntity1,testEntity2,testEntity4});

        Mockito.doNothing().when(testCheckInRepository).delete(testEntity3);
        Mockito.when(testCheckInRepository.findAll()).thenReturn(testList);
        testCheckInController.deleteCheckIn(3);
        Assert.assertEquals(testList,testCheckInController.getCheckIns());
    }
}
