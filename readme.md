# **Challenge Hotel Alura**

## **View: _Busqueda_**
Implementar el sistema en componentes visuales separados de acuerdo a sus funcionalidades.

<br>

 - ###  **Componente: Tabla**
   La **fila** es el principal medio de interacción. Cualquier operación..

     - **Visualización**
     - **Edición**
     - **Eliminación**
     
   ...debe ser canalizada  al controlador y/o viceversa.

   Así mismo una **fila** representa una **modelo de datos(_objeto_)** por tanto debe ser posible...

     - **Integrar**
     - **Desintegrar**
  
   ...los datos de una fila como un unico objeto.

# DEFINICIÓN DEL SISTEMA

<br>

  - ## **Package: _hotel.alura.models_**

    Define las **interfaces**(_que llevan el sufijo **DataSchema**_) del **modelo de negocios** de la aplicación. Dichas interfaces permiten el **intercambio de datos coherente y cohesivo** entre los diferentes subsistemas de la aplicación.

    <br>

    ### **Interfaces** _definidas_

      - _**Guest**DataSchema_
      - _**Reservation**DataSchema_
    
  <br>

  - ## **Package: _hotel.alura.models.db_**

    Define las **entidades** que permiten la interacción con la **base de datos**. Estas **clases** implementan las **interfaces _DataSchema_**.
  
    <br>

    ### **Clases** _definidas_

    - **Guest**_Entity_
    - **Reservation**_Entity_

  <br>

  - ## **Package: _hotel.alura.models.view_**

    Define el **modelo de datos** de los **componentes visuales**. Estas **clases** implementan las **interfaces _DataSchema_**.

    <br>

    ### **Clases** _definidas_

    - **Guest**_Row_
    - **Reservation**_Row_
