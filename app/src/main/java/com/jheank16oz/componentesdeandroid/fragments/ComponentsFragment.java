package com.jheank16oz.componentesdeandroid.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jheank16oz.componentesdeandroid.R;
import com.jheank16oz.componentesdeandroid.adapters.ComponentsAdapter;
import com.jheank16oz.componentesdeandroid.models.Component;

import java.util.ArrayList;

import static android.support.v7.widget.DividerItemDecoration.VERTICAL;

public class ComponentsFragment extends Fragment {


    private static ArrayList<Component> components = new ArrayList<>();
    private ComponentsAdapter componentsAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_components, container, false);

        initializeComponents(view);
        return view;
    }

    /**
     * metodo encargado de inicializar los componentes,
     * esto para desalojar el oncreate
     * @param view fragment
     */
    private void initializeComponents(View view) {
        RecyclerView mRecyclerView = view.findViewById(R.id.gridview);
        componentsAdapter = new ComponentsAdapter(getContext(), components);
        mRecyclerView.addItemDecoration(new DividerItemDecoration(getContext(), VERTICAL));
        mRecyclerView.setAdapter(componentsAdapter);

        getComponents();
    }

    private void getComponents() {
        components.clear();
        for (int i = 0; i < componentNames.length; i++) {
            components.add(new Component(componentNames[i], componentImages[i], componentContents[i]));
        }
        componentsAdapter.notifyDataSetChanged();
    }

    private static String[] componentNames = new String[]{
            "Bottom navigation",
            "Bottom sheets",
            "Buttons",
            "Buttons: Floating Action Button",
            "Cards",
            "Chips",
            "Data tables",
            "Dialogs",
            "Dividers",
            "Expansion panels",
            "Grid lists",
            "Lists",
            "Lists: Controls",
            "Menus",
            "Pickers",
            "Progress activity",
            "Selection controls",
            "Sliders",
            "Snackbars, toasts",
            "Steppers",
            "Subheaders",
            "Tabs",
            "Text fields",
            "Toolbars",
            "Tooltips",
            "Widgets"
    };

    private static int[] componentImages = new int[]{
            R.drawable.bottom_navigation,
            R.drawable.bottom_sheets,
            R.drawable.buttons,
            R.drawable.buttons_fab,
            R.drawable.cards,
            R.drawable.chips,
            R.drawable.data_tables,
            R.drawable.dialogs,
            R.drawable.dividers,
            R.drawable.expansion_panels,
            R.drawable.grid_lists,
            R.drawable.lists,
            R.drawable.lists_controls,
            R.drawable.menus,
            R.drawable.pickers,
            R.drawable.progress_and_activity,
            R.drawable.selection_controls,
            R.drawable.sliders,
            R.drawable.snackbars,
            R.drawable.steppers,
            R.drawable.subheaders,
            R.drawable.tabs,
            R.drawable.text_fields,
            R.drawable.toolbars,
            R.drawable.tooltips,
            R.drawable.widgets_types_information
    };

    private static String[] componentContents = new String[]{
            "Facilitan explorar y cambiar entre las vistas de nivel superior en un solo toque.",
            "Se deslizan hacia arriba desde la parte inferior de la pantalla para revelar más contenido.",
            "Comunican la acción que ocurrirá cuando el usuario los toque.",
            "Representa la acción principal en una aplicación.",
            "Sirve como punto de entrada a información más detallada.",
            "Representan entidades complejas en bloques pequeños, como un contacto.",
            "Muestran conjuntos de datos sin formato. Suelen aparecer en productos empresariales de escritorio.",
            "Informan a los usuarios sobre una tarea específica y pueden contener información crítica, requerir decisiones o involucrar múltiples tareas.",
            "Es una regla delgada y ligera que agrupa el contenido en listas y diseños de página.",
            "Contienen flujos de creación y permiten una edición ligera de un elemento.",
            "Son una alternativa a las vistas de lista estándar.",
            "Presentan líneas de pedido múltiples verticalmente como un único elemento continuo.",
            "Muestran información y acciones para los elementos de la lista.",
            "Muestran una lista de opciones en una hoja transitoria de material.",
            "Proporcionan una forma simple de seleccionar un único valor de un conjunto predeterminado.",
            "Son indicaciones visuales de un contenido de carga de la aplicación.",
            "Permiten al usuario seleccionar opciones.",
            "Permiten a los usuarios seleccionar entre un rango de valores moviendo el control deslizante.",
            "Proporcionan comentarios breves sobre una operación a través de un mensaje en la parte inferior de la pantalla.",
            "Transmiten el progreso a través de los pasos numerados.",
            "Son fichas de lista que delinean secciones de una lista o lista de grillas.",
            "Facilitan explorar y cambiar entre diferentes vistas.",
            "Permiten a los usuarios ingresar, editar y seleccionar texto.",
            "Aparecen encima de la vista afectada por sus acciones.",
            "Son etiquetas de texto que aparecen cuando el usuario se desplaza, enfoca o toca un elemento.",
            "Muestran vistas con vista rápida de los datos y la funcionalidad más importantes de una aplicación."};

}
