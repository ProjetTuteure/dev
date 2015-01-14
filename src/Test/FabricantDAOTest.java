package Test;

import gpi.metier.Fabricant;
import gpi.metier.FabricantDAO;
import gpi.metier.Type;
import gpi.metier.TypeDAO;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class FabricantDAOTest {

    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void recupererAllFabricantTest(){
        FabricantDAO fabricantDAO=new FabricantDAO();
        List<Fabricant> fabricantList=fabricantDAO.recupererAllFabricant();
        System.out.println(fabricantList);
    }
}