// Manejo del menú lateral
const menuToggle = document.querySelector('.menu-toggle');
const menuItems = document.querySelector('#menu-items');

// Mostrar u ocultar el menú al hacer clic en el botón
menuToggle.addEventListener('click', () => {
  if (menuItems.style.display === 'none' || menuItems.style.display === '') {
    menuItems.style.display = 'block';
  } else {
    menuItems.style.display = 'none';
  }
});

// Manejo de clics en los elementos del menú lateral
document.querySelectorAll('.menu-item').forEach(item => {
  item.addEventListener('click', () => {
      // Redirección según el ID del elemento
      if (item.id === 'horario-btn') {
          window.location.href = 'horarioAlumno.html'; // Cambiar ruta si es necesario
      } else if (item.id === 'inicio-btn') {
          window.location.href = 'inicioAlumno.html'; // Cambiar ruta si es necesario
        } else if (item.id === 'asistencia-btn') {
          window.location.href = 'asistenciaAlumno.html'; // Cambiar ruta si es necesario
      } else if (item.id === 'logout-btn') {
          window.location.href = 'login.html'; // Cambiar ruta si es necesario
      }
  });
});

// Manejo del botón de notificaciones
const notificationIcon = document.querySelector('.header-icons .icon:nth-child(1)');
if (notificationIcon) {
  notificationIcon.addEventListener('click', () => {
    alert('No tienes nuevas notificaciones.');
  });
}

// Manejo del perfil
const profileIcon = document.querySelector('.header-icons .icon:nth-child(3)');
if (profileIcon) {
  profileIcon.addEventListener('click', () => {
    alert('Accediendo a tu perfil...');
  });
}

// Configuración de gráficos usando Chart.js

// Gráfico de pastel (asistencia total)
const ctxPie = document.getElementById('pieChart').getContext('2d');
new Chart(ctxPie, {
    type: 'pie', // Tipo de gráfico: pastel
    data: {
        labels: ['Presente', 'Retraso', 'Ausente', 'Ausencia Justificada'], // Etiquetas para los segmentos
        datasets: [{
            data: [80, 10, 5, 5], // Datos ficticios (pueden ajustarse dinámicamente)
            backgroundColor: ['#4CAF50', '#FFEB3B', '#F44336', '#03A9F4'], // Colores de cada segmento
            hoverOffset: 4, // Desplazamiento al pasar el ratón sobre un segmento
        }]
    },
    options: {
        responsive: true, // Hace que el gráfico sea responsive
        plugins: {
            legend: {
                display: true, // Mostrar la leyenda
                position: 'top', // Colocar la leyenda en la parte superior
                labels: {
                    font: {
                        size: 14, // Tamaño de la fuente de la leyenda
                    }
                }
            },
            tooltip: {
                callbacks: {
                    label: function(tooltipItem) {
                        let label = tooltipItem.label || '';
                        if (tooltipItem.raw !== undefined) {
                            label += ': ' + tooltipItem.raw + '%'; // Muestra el valor en porcentaje
                        }
                        return label;
                    }
                }
            }
        }
    }
});

// Gráfico de línea (evolución de asistencia por día)
const ctxLine = document.getElementById('lineChart').getContext('2d');
new Chart(ctxLine, {
    type: 'line', // Tipo de gráfico: línea
    data: {
        labels: ['13/12', '14/12', '15/12', '16/12'], // Fechas ficticias
        datasets: [{
            label: 'Evolución % asistencia', // Etiqueta del gráfico de línea
            data: [100, 95, 90, 85], // Datos ficticios de asistencia
            borderColor: '#4CAF50', // Color de la línea
            backgroundColor: 'rgba(76, 175, 80, 0.2)', // Color de fondo (transparente)
            fill: true, // Rellenar el área bajo la línea
            tension: 0.3, // Curvatura de la línea
            pointRadius: 5, // Radio de los puntos sobre la línea
            pointBackgroundColor: '#4CAF50', // Color de los puntos
        }]
    },
    options: {
        responsive: true, // Hace que el gráfico sea responsive
        scales: {
            y: {
                beginAtZero: true, // Empieza en 0 en el eje Y
                max: 100, // El valor máximo en el eje Y será 100
                ticks: {
                    stepSize: 10, // Incremento de las marcas en el eje Y
                }
            }
        },
        plugins: {
            legend: {
                display: false, // Desactivar la leyenda en este gráfico
            },
            tooltip: {
                callbacks: {
                    label: function(tooltipItem) {
                        return tooltipItem.raw + '%'; // Muestra el valor en porcentaje
                    }
                }
            }
        }
    }
});
