/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.com.hkt.provider.spi;

import java.util.ArrayList;
import java.util.List;
import vn.com.hkt.dao.api.IDepartmentDao;
import vn.com.hkt.dao.api.IEmployeeDao;
import vn.com.hkt.dao.api.IEnterpriseDao;
import vn.com.hkt.dao.api.IOperationDao;
import vn.com.hkt.dao.api.IProjectDao;
import vn.com.hkt.dao.api.IUnitMoneyDao;
import vn.com.hkt.dao.spi.DepartmentDao;
import vn.com.hkt.dao.spi.EmployeeDao;
import vn.com.hkt.dao.spi.EnterpriseDao;
import vn.com.hkt.dao.spi.OperationDao;
import vn.com.hkt.dao.spi.ProjectDao;
import vn.com.hkt.dao.spi.UnitMoneyDao;
import vn.com.hkt.data.entity.Department;
import vn.com.hkt.data.entity.Employee;
import vn.com.hkt.data.entity.Enterprise;
import vn.com.hkt.data.entity.Operation;
import vn.com.hkt.data.entity.Project;
import vn.com.hkt.data.entity.UnitMoney;
import vn.com.hkt.provider.api.IProviderPanelShowOperation;

/**
 *
 * @author QuynhNguyen
 */
public class ProviderPanelShowOperation implements IProviderPanelShowOperation {

    private Operation operation;
    private IOperationDao iOperationDao;
    IDepartmentDao iDepartmentDao;
    IEnterpriseDao iEnterpriseDao;
    IProjectDao iProjectDao;
    IUnitMoneyDao iUnitMoneyDao;
    IEmployeeDao iEmployeeDao;

    public ProviderPanelShowOperation() {
        iOperationDao = new OperationDao();
        iDepartmentDao = new DepartmentDao();
        iEnterpriseDao = new EnterpriseDao();
        iProjectDao=new ProjectDao();
        iUnitMoneyDao=new UnitMoneyDao();
        iEmployeeDao=new EmployeeDao();
        
    }

    @Override
    public void setClassname(Class classname) {
        setClassname(Operation.class);
    }

    @Override
    public void setDataView(Operation object) {
        this.operation = object;
    }

    @Override
    public Operation getDataView() {
        if (operation == null) {
            operation = new Operation();

        }
        return operation;
    }

    @Override
    public long addData() {
        if (operation != null) {
            iOperationDao.insert(operation);
            return operation.getId();

        }
        return -1;
    }

    @Override
    public long deleteData() {
        if (operation != null) {
            iOperationDao.delete(operation);
            return operation.getId();

        }
        return -1;
    }

    @Override
    public long updateData() {
        if (operation != null) {
            iOperationDao.update(operation);
            return operation.getId();

        }
        return -1;
    }

    @Override
    public void resetData() {
        operation = new Operation();
    }

    @Override
    public void refreshData() {
        operation = iOperationDao.getById(getDataView().getId());
    }

    @Override
    public boolean checkData() {
        if (operation == null) {
            return true;

        }
        return false;
    }

    @Override
    public Operation getObjectbyID(long id) {
         if (id > 0) {
            return iOperationDao.getById(id);
        }
        return null;
    }

    @Override
    public List<Enterprise> getListEnterprise() {
        List<Enterprise> enterprises = iEnterpriseDao.selectAll();
        if (enterprises == null) {
            enterprises = new ArrayList<Enterprise>();
        }
        enterprises.add(0, null);
        return enterprises;
    }

    @Override
    public List<Department> getListDepartmentByIDEnt(long idEnterprise) {
         List<Department> listDep = iDepartmentDao.getByEntpriseId(idEnterprise);
        if (listDep == null) {
            listDep = new ArrayList<Department>();
        }
        listDep.add(0, null);
        return listDep;
    }

    @Override
    public List<Employee> getListEmployeeByIDDep(long idDepartment) {
        List<Employee> listEmp = iEmployeeDao.getByIdDepartment(idDepartment);
        if (listEmp == null) {
            listEmp = new ArrayList<Employee>();
        }
        listEmp.add(0, null);
        return listEmp;
    }

    @Override
    public List<Project> getListProjectByIDEnt(long idEnterprise) {
         List<Project> listPro = iProjectDao.getByIdEnterPrise(idEnterprise);
        if (listPro == null) {
            listPro = new ArrayList<Project>();
        }
        listPro.add(0, null);
        return listPro;
    }

    @Override
    public List<UnitMoney> getListUnitMoney() {
        List<UnitMoney> unitMoneys = iUnitMoneyDao.selectAll();
        return unitMoneys;
    }
}
