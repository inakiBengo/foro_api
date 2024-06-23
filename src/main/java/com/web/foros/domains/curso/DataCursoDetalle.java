package com.web.foros.domains.curso;

public record DataCursoDetalle(
        Long id,
        String nombre,
        Categoria categoria
) {
    public DataCursoDetalle (Curso curso) {
        this(curso.getId(), curso.getNombre(),curso.getCategoria());
    }
}
