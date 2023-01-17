package com.cybersoft.hotel_booking.service;

import com.cybersoft.hotel_booking.entity.VoucherEntity;
import com.cybersoft.hotel_booking.repository.VoucherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VoucherServiceImp implements VoucherService {
    @Autowired
    private VoucherRepository voucherRepository;

    //CRUD
    @Override
    public VoucherEntity addVoucher(VoucherEntity voucherEntity) {
        voucherEntity.setId(0);
        return voucherRepository.save(voucherEntity);
    }

    @Override
    public List<VoucherEntity> findAllVoucher() {
        return voucherRepository.findAll();
    }

    @Override
    public VoucherEntity findVoucherById(Integer id) {
        return voucherRepository.findById(id).orElse(null);
    }

    @Override
    public VoucherEntity updateVoucher(Integer id, VoucherEntity voucherEntity) {
        boolean exist = voucherRepository.existsById(id);
        if (exist) {
            voucherEntity.setId(id);
            return voucherRepository.save(voucherEntity);
        }
        return null;
    }

    @Override
    public boolean deleteVoucherById(Integer id) {
        boolean exist = voucherRepository.existsById(id);
        if (exist) {
            voucherRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
