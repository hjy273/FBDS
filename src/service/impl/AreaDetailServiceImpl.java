package service.impl;

import dao.impl.AreaDetailDaoImpl;
import model.AreaDetail;
import service.AreaDetailService;

import java.util.List;

/**
 * Created by hadoop on 9/14/17.
 */
public class AreaDetailServiceImpl implements AreaDetailService {
    @Override
    public List<AreaDetail> getAreaDetailByAreaId(int areaId) {
        return new AreaDetailDaoImpl().getAreaDetailByAreaId(areaId);
    }

    @Override
    public List<AreaDetail> getAllAreaDetail() {
        return new AreaDetailDaoImpl().getAllAreaDetail();
    }

    @Override
    public int getAreaId(String name) {
        return new AreaDetailDaoImpl().getAreaId(name);
    }
}
