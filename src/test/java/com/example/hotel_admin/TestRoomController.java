package com.example.hotel_admin;

import com.example.hotel_admin.controller.RoomController;
import com.example.hotel_admin.entity.RoomEntity;
import com.example.hotel_admin.repository.CheckInRepository;
import com.example.hotel_admin.repository.RoomRepository;
import com.example.hotel_admin.service.CheckInService;
import com.example.hotel_admin.service.RoomService;
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
public class TestRoomController
{
    @Mock
    private CheckInRepository testCheckInRepository;
    @Mock
    private RoomRepository testRoomRepository;
    private RoomService testRoomService;
    private CheckInService testCheckInService;
    private RoomController testRoomController;


    void init()
    {
        MockitoAnnotations.initMocks(this);
        testRoomService = new RoomService(testRoomRepository);
        testRoomController = new RoomController(testRoomService,testCheckInService,testCheckInRepository);
    }

    @Test
    public void testCreateGetRoom() throws Exception
    {
        init();
        RoomEntity testRoom = new RoomEntity();

        Mockito.when(testRoomRepository.save(testRoom)).thenReturn(testRoom);
        testRoomController.addRoom(testRoom);

        List<RoomEntity> testList = Arrays.asList(new RoomEntity[]{testRoom});
        Mockito.when(testRoomRepository.findAll()).thenReturn(testList);
        Assert.assertEquals(testList,testRoomController.getRooms());
    }

    @Test
    public void testGetRoomByID() throws Exception
    {
        init();
        RoomEntity testRoom1 = new RoomEntity();
        RoomEntity testRoom2 = new RoomEntity();

        testRoomController.addRoom(testRoom1);
        testRoomController.addRoom(testRoom2);
        List<RoomEntity> testList = Arrays.asList(new RoomEntity[]{testRoom1,testRoom2});

        Mockito.when(testRoomRepository.findById(2)).thenReturn(Optional.of(testRoom2));
        Assert.assertEquals(Optional.of(testRoom2),testRoomController.getRoomById(2));
    }

    @Test
    public void testDeleteAdmin() throws Exception
    {
        init();
        Date date = new Date();
        RoomEntity room = new RoomEntity();
        RoomEntity guest = new RoomEntity();
        RoomEntity testRoom1 = new RoomEntity();
        RoomEntity testRoom2 = new RoomEntity();
        RoomEntity testRoom3 = new RoomEntity();
        RoomEntity testRoom4 = new RoomEntity();

        testRoomController.addRoom(testRoom1);
        testRoomController.addRoom(testRoom2);
        testRoomController.addRoom(testRoom3);
        testRoomController.addRoom(testRoom4);
        List<RoomEntity> testList = Arrays.asList(new RoomEntity[]{testRoom1,testRoom2,testRoom4});

        Mockito.doNothing().when(testRoomRepository).delete(testRoom3);
        Mockito.when(testRoomRepository.findAll()).thenReturn(testList);
        testRoomController.deleteRoom(3);
        Assert.assertEquals(testList,testRoomController.getRooms());
    }
}
