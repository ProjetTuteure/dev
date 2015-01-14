package Test;

import gpi.metier.Type;
import gpi.metier.TypeDAO;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class TypeDAOTest {

    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void recupererTypeParIdTest(){
        //Given
        String nomType="PC";
        TypeDAO typeDAO=new TypeDAO();
        //When
        Type type=typeDAO.recupererTypeParId(nomType);
        //Then
        System.out.println(type.getNomTypeString());
        System.out.println(type.getCheminImageType().getValue());
       // Assert.assertEquals(new Type("PC","sources/images/pc.jpg"),type);
    }

    @Test
    public void recupererAllTypeTest(){
        TypeDAO typeDAO=new TypeDAO();
        List<Type> typeList=typeDAO.recupererAllType();
        List<Type> typeListResult=new ArrayList<Type>();
        typeListResult.add(new Type("Clef 3G","sources/images/cle3G.PNG"));
        typeListResult.add(new Type("PC","sources/images/pc.jpg"));
        typeListResult.add(new Type("Routeur","sources/images/routeur.png"));
        typeListResult.add(new Type("Switch","sources/images/switch.jpg"));
        System.out.println(typeList);
        System.out.println(typeListResult);
        for (int i=0;i<typeList.size();i++){
            Assert.assertEquals(typeList.get(i).getNomTypeString(),typeListResult.get(i).getNomTypeString());
            Assert.assertEquals(typeList.get(i).getCheminImageType().getValue(),typeListResult.get(i).getCheminImageType().getValue());
        }
    }


    @Test
    public void ajouterTypeTest(){
        TypeDAO typeDAO=new TypeDAO();
        typeDAO.ajouterType(new Type("test","test"));
        List<Type> typeList=typeDAO.recupererAllType();
        System.out.println(typeList);
        typeDAO.supprimerType(new Type("test", "test"));
        System.out.println(typeList);
    }

    @Test
    public void modifierTypeTest(){
        TypeDAO typeDAO=new TypeDAO();
        typeDAO.modifierType(new Type("Switch","PENI"));
        List<Type> typeList=typeDAO.recupererAllType();
        System.out.println(typeList);
        typeDAO.modifierType(new Type("Switch","sources/images/switch.jpg"));
        System.out.println(typeList);
    }

    @Test
    public void supprimerTypeTest(){
        TypeDAO typeDAO=new TypeDAO();
        typeDAO.ajouterType(new Type("test","test"));
        typeDAO.supprimerType(new Type("test", "test"));
        List<Type> typeList=typeDAO.recupererAllType();
        System.out.println(typeList);
    }


}