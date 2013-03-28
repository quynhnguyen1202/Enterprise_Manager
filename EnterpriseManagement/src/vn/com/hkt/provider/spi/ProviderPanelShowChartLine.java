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
import vn.com.hkt.dao.api.IProjectDao;
import vn.com.hkt.dao.spi.DepartmentDao;
import vn.com.hkt.dao.spi.EmployeeDao;
import vn.com.hkt.dao.spi.EnterpriseDao;
import vn.com.hkt.dao.spi.ProjectDao;
import vn.com.hkt.data.entity.Department;
import vn.com.hkt.data.entity.Employee;
import vn.com.hkt.data.entity.Enterprise;
import vn.com.hkt.data.entity.Project;
import vn.com.hkt.provider.api.IProviderPanelShowChartLine;

/**
 *
 * @author Administrator
 */
public class ProviderPanelShowChartLine implements IProviderPanelShowChartLine {
    private IEmployeeDao iEmployeeDao;
    private IEnterpriseDao iEnterpriseDao; 
    private IDepartmentDao iDepartmentDao;
    private IProjectDao iProjectDao;
    public ProviderPanelShowChartLine() {
        iDepartmentDao=new DepartmentDao();
        iEmployeeDao=new EmployeeDao();
        iEnterpriseDao=new EnterpriseDao();
        iProjectDao=new ProjectDao();
    }

    
    
    @Override
    public List<Enterprise> getListEnterprise() {
        List<Enterprise> enterprises=iEnterpriseDao.selectAll();
        if(enterprises==null){
            enterprises=new ArrayList<Enterprise>();
        }
        enterprises.add(0, null);
        return enterprises;
    }

    @Override
    public List<Department> getListDepartmentByIdEnt(long idEnterprise) {
         List<Department> listDep = iDepartmentDao.getByEntpriseId(idEnterprise);
        if (listDep == null) {
            listDep = new ArrayList<Department>();
        }
        listDep.add(0, null);
        return listDep;
    }

    @Override
    public List<Employee> getListEmployeeByIdDep(long idDepartment) {
        List<Employee> listEmp = iEmployeeDao.getByIdDepartment(idDepartment);
        if (listEmp == null) {
            listEmp = new ArrayList<Employee>();
        }
        listEmp.add(0, null);
        return listEmp;
    }

    @Override
    public List<Project> getListProjectIdEnt(long idEnterprise) {
        List<Project> listPro = iProjectDao.getByIdEnterPrise(idEnterprise);
        if (listPro == null) {
            listPro = new ArrayList<Project>();
        }
        listPro.add(0, null);
        return listPro;
    }

    @Override
    public List<Project> getListProject() {
        List<Project> projects=iProjectDao.selectAll();
        if(projects==null){
            projects=new ArrayList<Project>();
        }
        projects.add(0, null);
        return projects;
    }

    @Override
    public List<Project> getListProjectByIdDep(long idDepartment) {
        List<Project> listPro = iProjectDao.getByIdDepartment(idDepartment);
        if (listPro == null) {
            listPro = new ArrayList<Project>();
        }
        listPro.add(0, null);
        return listPro;
    }

   
    
}
