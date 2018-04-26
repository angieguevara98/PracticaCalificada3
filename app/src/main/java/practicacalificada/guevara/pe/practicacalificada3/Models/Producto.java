package practicacalificada.guevara.pe.practicacalificada3.Models;

import com.orm.dsl.Table;

/**
 * Created by Alumno on 26/04/2018.
 */
@Table

public class Producto {

        private Long id;
        private String fullname;
        private String categoria;
        private String precio;
        private String descripcion;

        public Producto() {
        }

        public Producto(String fullname, String precio, String descripcion, String Categoria) {
            this.precio = precio;
            this.descripcion = descripcion;
            this.fullname = fullname;
            this.categoria = categoria;
        }

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getFullname() {
            return fullname;
        }

        public void setFullname(String fullname) {
            this.fullname = fullname;
        }

        public String getPrecio() {
            return precio;
        }

        public void setPrecio(String precio) {
            this.precio = precio;
        }

        public String getDescripcion() {
            return descripcion;
        }

        public void setDescripcion(String descripcion) {
            this.descripcion = descripcion;
        }
        public String getCategoria() {
        return categoria;
    }

        public void setCategoria(String categoria) {
        this.descripcion = categoria;
         }

        @Override
        public String toString() {
            return "Producto{" +
                    "id=" + id +
                    ", fullname='" + fullname + '\'' +
                    ", precio'" + precio + '\'' +
                    ", descripcion='" + descripcion + '\'' +
                    ", categoria='" + categoria + '\'' +
                    '}';
        }
    }


