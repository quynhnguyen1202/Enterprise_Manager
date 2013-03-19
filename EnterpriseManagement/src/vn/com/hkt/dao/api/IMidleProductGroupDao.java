/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.com.hkt.dao.api;

import java.util.List;
import vn.com.hkt.data.entity.MidleProductGroup;

/**
 *
 * @author QuynhNguyen
 */
public interface IMidleProductGroupDao extends IEntityDao<MidleProductGroup> {

    public List<MidleProductGroup> getByIdProduct(long id);

    public List<MidleProductGroup> getByIdGroupProduct(long id);
}
