package practicacalificada.guevara.pe.practicacalificada3.Repositories;

import com.orm.SugarRecord;

import java.util.List;

import practicacalificada.guevara.pe.practicacalificada3.Models.Producto;

/**
 * Created by Alumno on 26/04/2018.
 */

public class ProductoRepository {


        public static List<Producto> list(){
            List<Producto> producto = SugarRecord.listAll(Producto.class);
            return producto;
        }

        public static Producto read(Long id){
            Producto producto = SugarRecord.findById(Producto.class, id);
            return producto;
        }

        public static void create(String fullname, String precio, String descripcion, String categoria){
            Producto producto = new Producto(fullname, precio, descripcion, categoria);
            SugarRecord.save(producto);
        }

        public static void update(String fullname, String precio, String descripcion, String calegoria, Long id){
            Producto producto = SugarRecord.findById(Producto.class, id);
            producto.setFullname(fullname);
            producto.setPrecio(precio);
            producto.setDescripcion(descripcion);
            producto.setCategoria(calegoria);
            SugarRecord.save(producto);
        }

        public static void delete(Long id){
            Producto producto = SugarRecord.findById(Producto.class, id);
            SugarRecord.delete(producto);
        }

    }


