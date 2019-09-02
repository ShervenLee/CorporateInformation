package com.vojs.web.controller;

import org.junit.Test;

import javax.rmi.CORBA.Tie;

/**
 * Created by apple on 16/10/14.
 */

public class UserActionTest {

    @Test
    public void testSendMobileCode() {
        new WxUserAction().sendCode("18652016815");
    }

    @Test
    public void testGetUserById() {
        new TiebaUserAction().getUserById("841d3dd3-077d-4538-9306-70b288cd5d02");
    }

    @Test
    public void testRegister() {
        new TiebaUserAction().register("15751775256", "cslg881025", 30, "xiaochen", "0", "");
    }


    @Test
    public void testGetUsers() {
        new TiebaUserAction().getUserByNickname("mouse");
    }

    @Test
    public void testAddContact() {
        new TiebaUserAction().addContact();
    }

    @Test
    public void testAddTag() {
        new TiebaUserAction().addTag();
    }

    @Test
    public void testAddAddress() {
        new TiebaUserAction().addAddress();
    }

    @Test
    public void testListAddress() {
        new TiebaUserAction().listAddress();
    }

    @Test
    public void testDeleteAddress() {
        new TiebaUserAction().deleteAddress();
    }

    @Test
    public void testUpdateAddress() {
        new TiebaUserAction().updateAddress();
    }
}
