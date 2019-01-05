package com.capgemini.app;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.capgemini.app.bean.Organization;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	ApplicationContext context = new ClassPathXmlApplicationContext("context.xml");
    	Organization  organization = (Organization) context.getBean("organization");
    	organization.getName();
    	organization.getBoardMembers();
    	organization.getBranchManagers();
    	organization.getCities();
    	organization.getOrgId();
    	organization.getShareValue();
    	organization.getDateOfEstablishment();
    	organization.isListed();
    	organization.getIpAddresses();
        
    }
}
