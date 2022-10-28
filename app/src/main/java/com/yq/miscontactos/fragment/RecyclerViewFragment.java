package com.yq.miscontactos.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.yq.miscontactos.R;
import com.yq.miscontactos.adapter.ContactoAdaptador;
import com.yq.miscontactos.pojo.Contacto;

import java.util.ArrayList;

public class RecyclerViewFragment extends Fragment {

    ArrayList<Contacto> contactos;
    private RecyclerView rvContactos;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_recyclerview, container, false);

        rvContactos = (RecyclerView) v.findViewById(R.id.rvContactos);
        //Lista
        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        //Cuadricula
        //GridLayoutManager glm = new GridLayoutManager(this, 2);

        rvContactos.setLayoutManager(llm);
        inicializarListaContactos();
        inicializarAdaptador();

        return v;
        //return super.onCreateView(inflater, container, savedInstanceState);
    }

    //Adaptador
    public ContactoAdaptador adaptador;
    private void inicializarAdaptador(){
        adaptador = new ContactoAdaptador(contactos,getActivity());
        rvContactos.setAdapter(adaptador);
    }
    public void inicializarListaContactos(){
        contactos = new ArrayList<>();

        contactos.add(new Contacto(R.mipmap.email, "Pablo Lopez", "3214567890", "pablo@gmail.com"));
        contactos.add(new Contacto(R.mipmap.email,"Julia Gomez", "7894561230", "julia@gmail.com"));
        contactos.add(new Contacto(R.mipmap.llamada,"Mireya Martinez", "4561023789", "mireya@gmail.com"));
        contactos.add(new Contacto(R.mipmap.llamada,"Pedro Sanchez", "0112546264", "pedro@gmail.com"));
    }
}
