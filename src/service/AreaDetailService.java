package service;

import model.AreaDetail;

import java.util.List;

/**
 * Created by hadoop on 9/14/17.
 */
public interface AreaDetailService {
    /**
     * 根据商圈编号获取商圈详情对象
     * @param areaId 商圈id
     * @return AreaDetail 商圈详情对象
     */
    public List<AreaDetail> getAreaDetailByAreaId(int areaId);
    /**
     * 根据商圈编号获取所有的商圈详情对象
     * @return List<AreaDetail> 商圈详情对象List
     */
    public List<AreaDetail> getAllAreaDetail();
    public int getAreaId(String name);
}
