document.addEventListener("DOMContentLoaded", () => {
    const userForm = document.getElementById("user-form");
    const userTable = document.getElementById("user-table").querySelector("tbody");
    const logoutText = document.getElementById('logout-btn');  // Seleccionamos el texto de Cerrar Sesión

    // Evento para añadir un usuario
    userForm.addEventListener("submit", (e) => {
        e.preventDefault();

        // Capturamos los valores
        const name = document.getElementById("name").value.trim();
        const role = document.getElementById("role").value;

        if (name && role) {
            addUserToTable(name, role);
            userForm.reset();
        } else {
            alert("Por favor completa todos los campos.");
        }
    });

    // Función para añadir una fila a la tabla
    function addUserToTable(name, role) {
        const row = document.createElement("tr");

        row.innerHTML = `
            <td>${name}</td>
            <td>${role}</td>
            <td><button class="delete-btn">Eliminar</button></td>
        `;

        // Agregamos el evento al botón de eliminar
        row.querySelector(".delete-btn").addEventListener("click", () => {
            row.remove();
        });

        userTable.appendChild(row);
    }

    // Evento para el texto de Cerrar Sesión
    logoutText.addEventListener('click', function() {
        window.location.href = 'login.html';  // Redirige al login
    });
});
