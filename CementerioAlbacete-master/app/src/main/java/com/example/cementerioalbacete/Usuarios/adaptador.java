package com.example.cementerioalbacete.Usuarios;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cementerioalbacete.R;

import java.util.ArrayList;

public class adaptador extends RecyclerView.Adapter<adaptador.cementerioviewholder> {
    ArrayList<Cementerio> listacemen;
    public adaptador(ArrayList<Cementerio> listacemen)
    {
        this.listacemen = listacemen;

    }

    @NonNull
    @Override
    public cementerioviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.lista_item_consulta,null,false);
   return new cementerioviewholder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull cementerioviewholder holder, int position) {

            String datos =" Patio: "+listacemen.get(position).getPatio()+" Pabellón: "+listacemen.get(position).getPabellon()+" Fila: "+listacemen.get(position).getFila()+" Número: " + listacemen.get(position).getNumero();
    holder.res.setText(datos);
    }

    @Override
    public int getItemCount() {
      return  listacemen.size();

    }

    public class cementerioviewholder extends RecyclerView.ViewHolder {
        TextView res ;

        public cementerioviewholder(@NonNull View itemView) {

            super(itemView);

            res = itemView.findViewById(R.id.localizaciondif);
        }
    }
}
