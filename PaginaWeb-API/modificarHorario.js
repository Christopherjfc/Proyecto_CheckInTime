// Manejo del botón para mostrar/ocultar el menú
const menuToggle = document.querySelector('.menu-toggle');
const menuItems = document.querySelector('#menu-items');

menuToggle.addEventListener('click', () => {
    // Alternar entre mostrar u ocultar el menú
    if (menuItems.style.display === 'none' || menuItems.style.display === '') {
        menuItems.style.display = 'block';
    } else {
        menuItems.style.display = 'none';
    }
});

// Manejo de clics en los elementos del menú lateral
document.querySelectorAll('.menu-item').forEach(item => {
    item.addEventListener('click', () => {
        if (item.id === 'inicio-btn') {
            window.location.href = 'inicioProfesor.html';
        } else if (item.id === 'horario-btn') {
            window.location.href = 'horarioProfesor.html';
        } else if (item.id === 'gestion-btn') {
            window.location.href = 'asistencia.html';
        } else if (item.id === 'marcaje-btn') {
            window.location.href = 'marcaje.html';    
        } else if (item.id === 'logout-btn') {
            window.location.href = 'login.html';
        }
    });
});

// Funcionalidad para los selectores (Aula, Ciclo, Curso, Grupo, Hora)
document.addEventListener("DOMContentLoaded", function () {
    const aulaSelect = document.querySelector('select[name="aula"]');
    const cicloSelect = document.querySelector('select[name="ciclo"]');
    const cursoSelect = document.querySelector('select[name="curso"]');
    const grupoSelect = document.querySelector('select[name="grupo"]');
    const horaSelect = document.querySelector('select[name="hora"]');
    const tabla = document.querySelector('table');
    const guardarButton = document.querySelector('.guardar-button');

    const aulas = ["A01", "A02", "A03", "A04", "A05"];
    const ciclos = ["DAW", "ASIX", "DAM"];
    const cursos = ["1", "2"];
    const grupos = ["A", "B", "C"];
    const horas = ["8:00 - 9:00", "9:00 - 10:00", "10:00 - 11:00", "11:00 - 11:30", "11:30 - 12:30", "12:30 - 13:30", "13:30 - 14:30",
        "14:30 - 15:30", "15:30 - 16:30", "16:30 - 17:30", "17:30 - 18:00", "18:00 - 19:00", "19:00 - 20:00", "20:00 - 21:00"];
    const dias = ["Lunes", "Martes", "Miércoles", "Jueves", "Viernes"];

    const coloresCiclo = {
        "DAW": "#FFFF99",  // Amarillo
        "ASIX": "#D9D9D9", // Gris
        "DAM": "#ADD8E6"   // Azul claro
    };

    function llenarSelect(selectElement, options) {
        options.forEach(option => {
            const optionElement = document.createElement('option');
            optionElement.value = option;
            optionElement.textContent = option;
            selectElement.appendChild(optionElement);
        });
    }

    llenarSelect(aulaSelect, aulas);
    llenarSelect(cicloSelect, ciclos);
    llenarSelect(cursoSelect, cursos);
    llenarSelect(grupoSelect, grupos);
    llenarSelect(horaSelect, horas);

    // Función para actualizar la tabla con los datos seleccionados
    function actualizarTabla() {
        const aula = aulaSelect.value;
        const ciclo = cicloSelect.value;
        const grupo = grupoSelect.value;
        const curso = cursoSelect.value;
        const hora = horaSelect.value;
        const dia = document.querySelector('select[name="dia"]').value;

        if (ciclo && grupo && curso && hora && dia) {
            // Encuentra la fila correspondiente a la hora seleccionada
            const fila = Array.from(tabla.querySelectorAll('tr')).find(row => {
                const horaCelda = row.querySelector('td');
                return horaCelda && horaCelda.textContent.trim() === hora;
            });

            if (fila) {
                // Determina el índice de la columna según el día seleccionado
                const diaIndex = dias.indexOf(dia) + 1; // +1 para saltar la columna de las horas

                if (diaIndex > 0) { // Asegurarse de que el día es válido
                    const targetCell = fila.querySelector(`td:nth-child(${diaIndex + 1})`); // Columna del día
                    if (targetCell) {
                        // Si ya hay un horario, no lo sobreescribimos sin preguntar
                        if (targetCell.innerHTML.trim() !== "") {
                            const confirmacion = confirm("¿Quieres reemplazar el horario existente?");
                            if (!confirmacion) return; // Si el usuario no confirma, no se reemplaza
                        }

                        // Insertar el horario en la celda
                        targetCell.innerHTML = `${aula} <br> ${ciclo}${curso}${grupo} <br><button class="delete-btn">Eliminar</button>`;
                        targetCell.style.backgroundColor = coloresCiclo[ciclo] || "#FFFFFF";

                        // Agregar evento al botón de eliminar
                        const deleteBtn = targetCell.querySelector('.delete-btn');
                        deleteBtn.addEventListener('click', () => {
                            // Eliminar el contenido de la celda y el color de fondo (blanco)
                            targetCell.innerHTML = '';
                            targetCell.style.backgroundColor = "white"; // Cambiar el color de fondo a blanco
                        });
                    }
                }
            }

            // Reiniciar los selects para una nueva selección
            aulaSelect.value = "";
            cicloSelect.value = "";
            cursoSelect.value = "";
            grupoSelect.value = "";
            horaSelect.value = "";
            document.querySelector('select[name="dia"]').value = "";
        }
    }

    // Asignar botones eliminar a las celdas predeterminadas (lunes 15:30 - 16:30 y martes 16:30 - 17:30)
    function asignarBotonesEliminar() {
        const celdasPredeterminadas = [
            { fila: 10, columna: 2, aula: "A04", ciclo: "DAW", grupo: "2B" }, // Lunes 15:30 - 16:30
            { fila: 11, columna: 3, aula: "A01", ciclo: "ASIX", grupo: "1C" }  // Martes 16:30 - 17:30
        ];

        celdasPredeterminadas.forEach(celda => {
            const fila = tabla.rows[celda.fila];
            const targetCell = fila.cells[celda.columna];
            if (targetCell) {
                // Solo agregar el botón de eliminar si la celda tiene contenido
                if (targetCell.innerHTML.trim() !== "") {
                    targetCell.innerHTML += ` <br><button class="delete-btn">Eliminar</button>`;
                    const deleteBtn = targetCell.querySelector('.delete-btn');
                    deleteBtn.addEventListener('click', () => {
                        // Eliminar el contenido de la celda y el color de fondo (blanco)
                        targetCell.innerHTML = '';  // Eliminar contenido
                        targetCell.style.backgroundColor = "white"; // Cambiar color de fondo a blanco
                    });
                }
            }
        });
    }

    asignarBotonesEliminar(); // Asignamos los botones de eliminar al cargar la página

    // Evento para el botón de guardar
    guardarButton.addEventListener('click', function () {
        const aula = aulaSelect.value;
        const ciclo = cicloSelect.value;
        const grupo = grupoSelect.value;
        const curso = cursoSelect.value;
        const hora = horaSelect.value;
        const dia = document.querySelector('select[name="dia"]').value;

        if (ciclo && grupo && curso && hora && dia) {
            actualizarTabla();
        } else {
            alert("Por favor, complete todos los campos.");
        }
    });
});
