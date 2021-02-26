/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;
import java.util.List;
import javax.persistence. *;
/**
 *
 * @author Ruben
 */
public class ProductosCRUD {
    
     public static List<Productos> getProductos() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("com.mycompany_productosCRUDupdate_war_1.0-SNAPSHOTPU");
        EntityManager manager = factory.createEntityManager();
        String sql = "SELECT * FROM productos";
        Query q = manager.createNativeQuery(sql,Productos.class); //método para consultas en SQL
        List<Productos> productosBD =  q.getResultList();

        return productosBD;        
        }
     
     public static int actualizaProductoTest() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("com.mycompany_productosCRUDupdate_war_1.0-SNAPSHOTPU");
        EntityManager manager = factory.createEntityManager();
        String sql = "UPDATE Productos p SET p.categoria = 'zumos' WHERE p.id = 13";
        Query q = manager.createQuery(sql,Productos.class);
        manager.getTransaction().begin();
        int filasAfectadas = q.executeUpdate();
        manager.getTransaction().commit();
        //manager.close();
        return filasAfectadas;      
    }
     
     public static int actualizaProducto() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("com.mycompany_productosCRUDupdate_war_1.0-SNAPSHOTPU");
        EntityManager manager = factory.createEntityManager();
        String sql = "UPDATE Productos p SET p.nombre = :nombre, p.imagen = :imagen, p.categoria = :categoria, p.precio = :precio WHERE p.id = :id";
        Query q = manager.createQuery(sql,Productos.class);
        q.setParameter("id", miProducto.getId());
        q.setParameter("categoria", "Digestivos");
        q.setParameter("nombre", "Pacharán");
        q.setParameter("imagen", "pacharan.jpg");
        q.setParameter("precio", 4.0);
        manager.getTransaction().begin();
        int filasAfectadas = q.executeUpdate();
        manager.getTransaction().commit();
        //manager.close();
        return filasAfectadas;      
    }
     
     public static void insertaProducto() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("com.mycompany_productosCRUDupdate_war_1.0-SNAPSHOTPU");
        EntityManager manager = factory.createEntityManager();
         manager.getTransaction().begin();
        manager.merge(producto);
        manager.getTransaction().commit();
        }




    
}
