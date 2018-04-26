package practicacalificada.guevara.pe.practicacalificada3.Adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import practicacalificada.guevara.pe.practicacalificada3.Models.Producto;
import practicacalificada.guevara.pe.practicacalificada3.Models.User;
import practicacalificada.guevara.pe.practicacalificada3.R;

import static practicacalificada.guevara.pe.practicacalificada3.R.id.precio_text;

/**
 * Created by Alumno on 26/04/2018.
 */

public class ProductoAdapter extends RecyclerView.Adapter<ProductoAdapter.ViewHolder> {


    private List<Producto> producto;

    public ProductoAdapter(List<Producto> producto){
        this.producto = producto;
    }

    public void setProducto(List<Producto> producto) {
        this.producto = producto;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        public TextView fullname;
        public TextView precio;
        public TextView descripcion;
        public TextView categoria;

        public ViewHolder(View itemView) {
            super(itemView);
            precio = (TextView) itemView.findViewById(precio_text);
            fullname = (TextView) itemView.findViewById(R.id.title_text);
            descripcion = (TextView) itemView.findViewById(R.id.description_text);
            categoria = (TextView) itemView.findViewById(R.id.categoria_text);

        }
    }

    @Override
    public ProductoAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_catalogo, parent, false);
        return new ViewHolder(itemView);
    }


    @Override
    public void onBindViewHolder(ProductoAdapter.ViewHolder viewHolder, int position) {
        Producto producto = this.producto.get(position);
        viewHolder.fullname.setText(producto.getFullname());
        viewHolder.precio.setText(producto.getPrecio());
        viewHolder.descripcion.setText(producto.getDescripcion());
        viewHolder.descripcion.setText(producto.getDescripcion());

    }

    @Override
    public int getItemCount() {
        return this.producto.size();
    }

}
