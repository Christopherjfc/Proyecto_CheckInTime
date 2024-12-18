package com.example.checkintime;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Menu_navegacio_alumno#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Menu_navegacio_alumno extends Fragment {

    private ImageView ajuda, casa, calend;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Menu_navegacio_alumno() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Menu_navegacio_alumno.
     */
    // TODO: Rename and change types and number of parameters
    public static Menu_navegacio_alumno newInstance(String param1, String param2) {
        Menu_navegacio_alumno fragment = new Menu_navegacio_alumno();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_menu_navegacio_alumno, container, false);

        ajuda = view.findViewById(R.id.ayuda);
        casa = view.findViewById(R.id.home);
        calend = view.findViewById((R.id.calendario));

        ajuda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Recibe el nombre de la actividad donde se encuentra
                String ActivityActual = getActivity().getClass().getSimpleName();

                // Verificar si la actividad es de Alumno o Profesor
                if (ActivityActual.startsWith("Alumno_")) {
                    Intent intent = new Intent(getActivity(), Alumno_ayudaContacto.class);
                    startActivity(intent);
                } else if (ActivityActual.startsWith("Profesor_")) {
                    Intent intent = new Intent(getActivity(), Profesor_ayudaContacto.class);
                    startActivity(intent);
                } else if (ActivityActual.startsWith("Admin_Alum")) {
                    Intent intent = new Intent(getActivity(), Admin_Alum_ayudaContacto.class);
                    startActivity(intent);
                } else if (ActivityActual.startsWith("Admin_Prof")) {
                    Intent intent = new Intent(getActivity(), Admin_Prof_ayudaContacto.class);
                    startActivity(intent);
                }
            }
        });

        casa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Recibe el nombre de la actividad donde se encuentra
                String ActivityActual = getActivity().getClass().getSimpleName();

                // Verificar si la actividad es de Alumno o Profesor
                if (ActivityActual.startsWith("Alumno_")) {
                    Intent intent = new Intent(getActivity(), Alumno_main.class);
                    startActivity(intent);
                } else if (ActivityActual.startsWith("Profesor_")) {
                    Intent intent = new Intent(getActivity(), Profesor_main.class);
                    startActivity(intent);
                } else if (ActivityActual.startsWith("Admin_Alum")) {
                    Intent intent = new Intent(getActivity(), Admin_Alum_main.class);
                    startActivity(intent);
                } else if (ActivityActual.startsWith("Admin_Prof")) {
                    Intent intent = new Intent(getActivity(), Admin_Prof_main.class);
                    startActivity(intent);
                }
            }
        });

        calend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Recibe el nombre de la actividad donde se encuentra
                String ActivityActual = getActivity().getClass().getSimpleName();

                // Verificar si la actividad es de Alumno o Profesor
                if (ActivityActual.startsWith("Alumno_")) {
                    Intent intent = new Intent(getActivity(), Alumno_horario.class);
                    startActivity(intent);
                } else if (ActivityActual.startsWith("Profesor_")) {
                    Intent intent = new Intent(getActivity(), Profesor_horario.class);
                    startActivity(intent);
                } else if (ActivityActual.startsWith("Admin_Alum")) {
                    Intent intent = new Intent(getActivity(), Admin_Alum_horario.class);
                    startActivity(intent);
                } else if (ActivityActual.startsWith("Admin_Prof")) {
                    Intent intent = new Intent(getActivity(), Admin_Prof_horario.class);
                    startActivity(intent);
                }
            }
        });
        return  view;
    }
}