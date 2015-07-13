package quick.db.connect;

import java.sql.Connection;
import java.sql.SQLException;
import junit.framework.TestCase;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import quick.db.exceptions.InvalidInputException;
import quick.db.exceptions.VendorNotFoundException;

/**
 *
 */
public class QuickDBConnectTest extends TestCase{
    
    private String vendor;
    private String hostname;
    private String port;
    private String schema;
    private String username;
    private String password;
    private Connection conn;
    
    
    public QuickDBConnectTest() {
    }
    
    
    @Before
    public void setUp() {
        conn = null;
        vendor = "MYSQL";
        hostname = "localhost";
        port = "3306";
        schema = "assembly";
        username = "root";
        password = "";
    }
    
    @After
    public void tearDown() throws SQLException {
        if(null != conn){
            conn.close();
        }
    }
    

    /**
     * Test VendorNotFoundException is thrown if vendor is null
     */
    @Test
    public void testNullVendor()  {
        
        vendor = null;
        try{
            QuickDBConnect.getConnection(vendor, hostname, port, schema, username, password);
            fail("should have thrown an exception");
        }
        catch(InvalidInputException e){
            System.out.println(e.getMessage());
            assertTrue(true);
        }
        catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    /**
     * Test VendorNotFoundException is thrown if vendor is invalid
     */
    @Test
    public void testBadVendor() {
        vendor = "Wrong";
        try{
            QuickDBConnect.getConnection(vendor, hostname, port, schema, username, password);
            fail("should have thrown an exception");
        }
        catch(VendorNotFoundException e){
            System.out.println(e.getMessage());
            assertTrue(true);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    /**
     * Pre: mysql database must be running
     * 
     * Tests that QuickDBConnect.getConnection returns a non null Connection
     * when all valid params are provided.
     */
    @Test
    public void testConnectionNotNull() {
        conn = null;
        try{
            conn = QuickDBConnect.getConnection(vendor, hostname, port, schema, username, password);
        }
        catch(VendorNotFoundException e){
            System.out.println(e.getMessage());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        assertNotNull(conn);
    }
    
    @Test
    public void testNullHostname() {
        hostname = null;
        try{
            QuickDBConnect.getConnection(vendor, hostname, port, schema, username, password);
            fail("should have thrown an exception");
        }
        catch(InvalidInputException e){
            System.out.println(e.getMessage());
            assertTrue(true);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            
        }
    }
    
    @Test
    public void testBadHostname() {
        hostname = "wrong.com";
        try{
            QuickDBConnect.getConnection(vendor, hostname, port, schema, username, password);
            fail("should have thrown an exception");
        }
        catch(InvalidInputException e){
            System.out.println(e.getMessage());
            assertTrue(true);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            
        }
    }
    
    @Test
    public void testNullPort() {
        port = null;
        try{
            QuickDBConnect.getConnection(vendor, hostname, port, schema, username, password);
            fail("should have thrown an exception");
        }
        catch(InvalidInputException e){
            System.out.println(e.getMessage());
            assertTrue(true);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            
        }
    }
    
    @Test
    public void testBadPort() {
        port = "bad";
        try{
            QuickDBConnect.getConnection(vendor, hostname, port, schema, username, password);
            fail("should have thrown an exception");
        }
        catch(InvalidInputException e){
            System.out.println(e.getMessage());
            assertTrue(true);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            
        }
    }
    
    @Test
    public void testNullSchema() {
        schema = null;
        try{
            QuickDBConnect.getConnection(vendor, hostname, port, schema, username, password);
            fail("should have thrown an exception");
        }
        catch(InvalidInputException e){
            System.out.println(e.getMessage());
            assertTrue(true);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            
        }
    }
    
    @Test
    public void testBadSchema() {
        schema = "2B@dSch3ma";
        try{
            QuickDBConnect.getConnection(vendor, hostname, port, schema, username, password);
            fail("should have thrown an exception");
        }
        catch(InvalidInputException e){
            System.out.println(e.getMessage());
            assertTrue(true);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    @Test
    public void testNullUsername() {
        username = null;
        try{
            QuickDBConnect.getConnection(vendor, hostname, port, schema, username, password);
            fail("should have thrown an exception");
        }
        catch(InvalidInputException e){
            System.out.println(e.getMessage());
            assertTrue(true);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            
        }
    }
    
    @Test
    public void testBadUsername() {
        username = "dummy123!";
        try{
            QuickDBConnect.getConnection(vendor, hostname, port, schema, username, password);
            fail("should have thrown an exception");
        }
        catch(InvalidInputException e){
            System.out.println(e.getMessage());
            assertTrue(true);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            
        }
    }
    
    @Test
    public void testNullPassword() {
        password = null;
        try{
            QuickDBConnect.getConnection(vendor, hostname, port, schema, username, password);
            fail("should have thrown an exception");
        }
        catch(InvalidInputException e){
            System.out.println(e.getMessage());
            assertTrue(true);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            
        }
    }
    
    @Test
    public void testBadPassword() {
        password = "  ";
        try{
            QuickDBConnect.getConnection(vendor, hostname, port, schema, username, password);
            fail("should have thrown an exception");
        }
        catch(InvalidInputException e){
            System.out.println(e.getMessage());
            assertTrue(true);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            
        }
    }
    
    //TODO 
    //add tests for getConnection(vendor, schema)
}
