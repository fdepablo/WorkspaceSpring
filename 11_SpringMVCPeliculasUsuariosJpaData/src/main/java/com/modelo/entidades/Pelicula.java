package com.modelo.entidades;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Entity
@Table(name="peliculas")
@Component
@Scope("prototype")
public class Pelicula {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	/*
	Podemos poner anotaciones de validacion de javax.validation
	Se validaran con ayuda de hibernate al intentar introducir registros 
	en la bbdd
	 
	Anotaciones más importantes:
	 
    @NotNull validates that the annotated property value is not null.
    @AssertTrue validates that the annotated property value is true.
    @Size validates that the annotated property value has a size between the attributes min and max; can be applied to String, Collection, Map, and array properties.
    @Min validates that the annotated property has a value no smaller than the value attribute.
    @Max validates that the annotated property has a value no larger than the value attribute.
    @Email validates that the annotated property is a valid email address.    
    
    @NotEmpty validates that the property is not null or empty; can be applied to String, Collection, Map or Array values.
    @NotBlank can be applied only to text values and validates that the property is not null or whitespace.
    @Positive and @PositiveOrZero apply to numeric values and validate that they are strictly positive, or positive including 0.
    @Negative and @NegativeOrZero apply to numeric values and validate that they are strictly negative, or negative including 0.
    @Past and @PastOrPresent validate that a date value is in the past or the past including the present; can be applied to date types including those added in Java 8.
    @Future and @FutureOrPresent validate that a date value is in the future, or in the future including the present.
	
	*/
	
	@NotBlank(message="Titulo vacio!! :(")
	private String titulo;
	@NotBlank
	private String genero;
	@Min(1800)
	@Max(2200)
	private int year;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	
	@Override
	public String toString() {
		return "Pelicula [id=" + id + ", titulo=" + titulo + ", genero=" + genero + ", year=" + year + "]";
	}
	
	
}
