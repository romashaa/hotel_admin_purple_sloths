package com.example.hotel_admin.JUnit_tests;

import com.example.hotel_admin.controller.AdminController;
import com.example.hotel_admin.entity.AdminEntity;
import com.example.hotel_admin.repository.AdminRepository;
import com.example.hotel_admin.service.AdminService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;


@ExtendWith(MockitoExtension.class)
public class TestAdminController
{

    @Mock
    private AdminRepository testAdminRepository;
    private AdminService testAdminService;
    private AdminController testAdminController;

    void init()
    {
        MockitoAnnotations.initMocks(this);
        testAdminService = new AdminService(testAdminRepository);
        testAdminController = new AdminController(testAdminService);
    }

    @Test
    public void testCreateGetAdmin() throws Exception
    {
        init();
        AdminEntity testAdmin = new AdminEntity(1,"Login","Password");

        Mockito.when(testAdminRepository.save(testAdmin)).thenReturn(testAdmin);
        testAdminController.addAdmin(testAdmin);

        List<AdminEntity> testList = Arrays.asList(new AdminEntity[]{testAdmin});

        Mockito.when(testAdminRepository.findAll()).thenReturn(testList);
        Assert.assertEquals(testList,testAdminController.getAdmins());
    }

    @Test
    public void testGetAdminByID() throws Exception
    {
        init();
        AdminEntity testAdmin1 = new AdminEntity(1,"Login","Password");
        AdminEntity testAdmin2 = new AdminEntity(2,"Login22","Password33");

        testAdminController.addAdmin(testAdmin1);
        testAdminController.addAdmin(testAdmin2);
        List<AdminEntity> testList = Arrays.asList(new AdminEntity[]{testAdmin1,testAdmin2});

        Mockito.when(testAdminRepository.findById(2)).thenReturn(Optional.of(testAdmin2));
        Assert.assertEquals(Optional.of(testAdmin2),testAdminController.getAdminById(2));
    }

    @Test
    public void testDeleteAdmin() throws Exception
    {
        init();
        AdminEntity testAdmin1 = new AdminEntity(1,"Login","Password");
        AdminEntity testAdmin2 = new AdminEntity(2,"Login22","Password33");
        AdminEntity testAdmin3 = new AdminEntity(3,"Login1212","Password1212121");
        AdminEntity testAdmin4 = new AdminEntity(4,"Login221212","Password331211212");
        testAdminController.addAdmin(testAdmin1);
        testAdminController.addAdmin(testAdmin2);
        testAdminController.addAdmin(testAdmin3);
        testAdminController.addAdmin(testAdmin4);
        List<AdminEntity> testList = Arrays.asList(new AdminEntity[]{testAdmin1,testAdmin2,testAdmin4});

        Mockito.doNothing().when(testAdminRepository).delete(testAdmin3);
        Mockito.when(testAdminRepository.findAll()).thenReturn(testList);
        testAdminController.deleteAdmin(3);
        Assert.assertEquals(testList,testAdminController.getAdmins());
    }
}
