package employee

import com.oodlestechnologies.blog.Application
import com.oodlestechnologies.blog.services.employee.EmployeeService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.SpringApplicationContextLoader

import org.springframework.test.context.ContextConfiguration
import spock.lang.Specification

@ContextConfiguration(loader = SpringApplicationContextLoader.class,classes = Application.class)
class EmployeeSpec extends  Specification{

    @Autowired
    EmployeeService employeeService;

    // fields
    // Fixture methods
    // Proxy Or CGLib


    // Feature methods
    def "check if employee exists"(){

        setup:
        long empid = 43;

        when:
        empid > 0

        then:
        employeeService.getEmployee(empid);
        employeeService!=null
    }
    // Helper methods
}