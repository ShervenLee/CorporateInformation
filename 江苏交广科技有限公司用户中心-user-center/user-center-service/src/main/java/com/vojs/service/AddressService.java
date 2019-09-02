package com.vojs.service;

import com.vojs.bean.domain.Address;
import com.vojs.bean.domain.User;
import com.vojs.bean.exception.VOJSException;
import com.vojs.dao.AddressMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by chenyunjie on 2017/4/28.
 */
@Service
public class AddressService {

    @Autowired
    private AddressMapper addressMapper;

    @Autowired
    private UserService userService;


    public AddressMapper getAddressMapper() {
        return addressMapper;
    }

    public void setAddressMapper(AddressMapper addressMapper) {
        this.addressMapper = addressMapper;
    }

    public Address addAddress(Address address) throws VOJSException {

        User user = userService.getUser(address.getUuid());

        address.setUserId(user.getId());

        int count = addressMapper.insertAddress(address);

        if (count == 0) {
            throw new VOJSException("新增地址失败");
        }

        if (address.getIsdefault() == 1) {
            try {
                addressMapper.setAddressUndefaultExceptId(address);
            } catch (Exception e){

            }
        }

        return address;
    }

    public Address updateAddress(Address address) throws VOJSException {

        int count = addressMapper.updateAddress(address);
        if (count == 0) {
            throw new VOJSException("更新地址失败");
        }

        if (address.getIsDefault() == 1) {
            try {
                addressMapper.setAddressUndefaultExceptId(address);
            } catch (Exception e){
            	System.out.println(e);
            }
        }

        return address;
    }

    public void deleteAddress(long id, String uuid) throws VOJSException {

        int count = addressMapper.deleteAddress(id, uuid);
        if (count == 0) {
            throw new VOJSException("删除地址失败");
        }
    }

    public List<Address> list(Address address) throws VOJSException {
        return  addressMapper.selectAddressList(address);
    }

}
