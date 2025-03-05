// URL de l'API backend
const apiUrl = 'http://localhost:8080/todo';

// Fonction pour créer une tâche
function createTask() {
    const title = document.getElementById('taskTitle').value;
    const description = document.getElementById('taskDescription').value;
    const status = document.getElementById('taskStatus').value;

    const newTask = {
        title: title,
        description: description,
        status: status
    };

    fetch(`${apiUrl}/createTask`, {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(newTask)
    })
    .then(response => response.json())
    .then(data => {
        console.log('Tâche créée', data);
        fetchTasks();  // Recharge la liste des tâches
    })
    .catch(error => {
        console.error('Erreur:', error);
    });
}

// Fonction pour récupérer toutes les tâches
function fetchTasks() {
    fetch(`${apiUrl}/getAll`)
    .then(response => response.json())
    .then(data => {
        const taskList = document.getElementById('taskList');
        taskList.innerHTML = '';  // Vide la liste existante
        data.forEach(task => {
            const li = document.createElement('li');
            li.textContent = `${task.title} (${task.status})`;
            taskList.appendChild(li);
        });
    })
    .catch(error => {
        console.error('Erreur:', error);
    });
}

// Charger les tâches au démarrage
window.onload = fetchTasks;
