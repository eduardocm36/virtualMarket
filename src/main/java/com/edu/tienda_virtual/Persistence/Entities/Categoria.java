package com.edu.tienda_virtual.Persistence.Entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "categorias")
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_categoria")
    private Integer idCategoria;
    @Column(name = "descripcion")
    private String descripcionCategoria;
    @Column(name = "estado")
    private Boolean estadoCategoria;

    // RELACION CATEGORIA - PRODUCTO
    @OneToMany(mappedBy = "categoria")
    private List<Producto> productos;


    //Getters and Setters

    public Integer getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(Integer idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getDescripcionCategoria() {
        return descripcionCategoria;
    }

    public void setDescripcionCategoria(String descripcionCategoria) {
        this.descripcionCategoria = descripcionCategoria;
    }

    public Boolean getEstadoCategoria() {
        return estadoCategoria;
    }

    public void setEstadoCategoria(Boolean estadoCategoria) {
        this.estadoCategoria = estadoCategoria;
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public void setProductos(List<Producto> productos) {
        this.productos = productos;
    }
}
