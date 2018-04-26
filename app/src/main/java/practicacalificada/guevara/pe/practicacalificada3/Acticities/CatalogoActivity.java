package practicacalificada.guevara.pe.practicacalificada3.Acticities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.List;

import practicacalificada.guevara.pe.practicacalificada3.Adapters.ProductoAdapter;
import practicacalificada.guevara.pe.practicacalificada3.Models.Producto;
import practicacalificada.guevara.pe.practicacalificada3.R;
import practicacalificada.guevara.pe.practicacalificada3.Repositories.ProductoRepository;

public class CatalogoActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();

    private static final int REGISTER_FORM_REQUEST = 100;

    private RecyclerView productoList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_catalogo);

        // Configure ReciclerView
        productoList= (RecyclerView) findViewById(R.id.producto_list);
        productoList.setLayoutManager(new LinearLayoutManager(this));

        // Set Data Adapter to ReciclerView
        List<Producto> producto = ProductoRepository.list();
        productoList.setAdapter(new ProductoAdapter(producto));

    }

    public void callRegisterForm(View view){
        startActivityForResult(new Intent(this, CatalogoActivity.class), REGISTER_FORM_REQUEST);
    }

    // return from RegisterActivity
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        // refresh data
        ProductoAdapter adapter = (ProductoAdapter)productoList.getAdapter();

        List<Producto> producto = ProductoRepository.list();
        adapter.setProducto(producto);
        adapter.notifyDataSetChanged();

    }

}

