package com.qz.zframe.tally.service.impl;

import com.qz.zframe.common.util.ErrorCode;
import com.qz.zframe.tally.dao.TallyQrCodeDao;
import com.qz.zframe.tally.entity.QrCode;
import com.qz.zframe.tally.service.TallyQrCodeService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("tallyQrCodeService")
@Transactional(rollbackFor = Exception.class)
public class TallyQrCodeServiceImpl implements TallyQrCodeService{
    @Autowired
    TallyQrCodeDao tallyQrCodeDao;

    @Override
    public List<QrCode> findAllQrCode() {
        return tallyQrCodeDao.findAllQrCode();
    }

    @Override
    public int insertByCodes(String code1, String code2, QrCode qrCode) {
        int count=tallyQrCodeDao.countByCodes(code1, code2);
        if (count>=(new Integer(code2)-new Integer(code1)+1)){
            return ErrorCode.ERROR;
        }
        String code3=String.valueOf(new Integer(code1)+1);
        qrCode.setCode(code3);
        tallyQrCodeDao.insertByCodes(qrCode);
        return ErrorCode.SUCCESS;
    }

    @Override
    public int countByCodes(String code1, String code2) {
        return tallyQrCodeDao.countByCodes(code1, code2);
    }

    @Override
    public QrCode findQrCodeByCode(String code) {
        return tallyQrCodeDao.findQrCodeByCode(code);
    }

    @Override
    public void updateQrCodeByCode(QrCode qrCode) {
        tallyQrCodeDao.updateQrCodeByCode(qrCode);
    }

    @Override
    public void deleteQrCodeByCode(String code) {
        tallyQrCodeDao.deleteQrCodeByCode(code);
    }

    @Override
    public int countQrCode() {
        return tallyQrCodeDao.countQrCode();
    }
}
