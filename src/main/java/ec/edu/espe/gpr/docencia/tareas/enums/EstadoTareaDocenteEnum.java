package ec.edu.espe.gpr.docencia.tareas.enums;

public enum EstadoTareaDocenteEnum {
    ASIGNADA("ASIGNADA", "ASIGNADA"),
    GUARDAR_BORRADOR("GUARDAR_BORRADOR", "Guardar como borrador"),
    EN_REVISION("EN REVISIÓN", "EN REVISIÓN"),
    SUBIDA_NO_ACEPTA_CAMBIOS("SUBIDA_NO_ACEPTA_CAMBIOS", "Actividad Subida y no se aceptan cambios"),
    DENEGADO("DENEGADO", "DENEGADO"),
    ACEPTADO("ACEPTADO", "ACEPTADO");


    private final String value;
    private final String text;

    private EstadoTareaDocenteEnum(String value, String text) {
        this.value = value;
        this.text = text;
    }

    public String getText() {
        return this.text;
    }

    public String getValue() {
        return this.value;
    }
}

