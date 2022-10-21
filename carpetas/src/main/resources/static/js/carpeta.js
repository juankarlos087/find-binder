const url = "http://localhost:8080/carpeta/"
const url1 = "http://localhost:8080/carpeta/list"
//const url = "http://150.136.211.43:8080/seguimiento/carpeta/"
//const url1 = "http://150.136.211.43:8080/seguimiento/carpeta/list"
const contenedor = document.querySelector('tbody')
let resultados = ''

const modalCarpetas = new bootstrap.Modal(document.getElementById('modalCarpeta'))
const formCarpetas = document.querySelector('form')
const idCarpeta = document.getElementById('id')
const nombreCarpeta = document.getElementById('nombre')
const identificacionCarpeta = document.getElementById('identificacion')
const codigoTipo = document.getElementById('codigo')
let opcion = ''

btnCrear.addEventListener('click', () => {
    idCarpeta.value = ''
    nombreCarpeta.value = ''
    identificacionCarpeta.value = ''
    codigoTipo.value = ''
    idCarpeta.disabled = false
    modalCarpetas.show()
    opcion = 'crear'
})

btnCerrar.addEventListener('click', () => {
    
    modalCarpetas.hide()
   
})

btnclose.addEventListener('click', () => {
    
    modalCarpetas.hide()
   
})
//funcion para mostrar resultados

const mostrar = (Carpetas) => {
    Carpetas.forEach(Carpeta => {
        resultados += `<tr>
                        <td>${Carpeta.codigo_car}</td>
                        <td>${Carpeta.nombre_emp}</td>
                        <td>${Carpeta.identificacion_emp}</td>
                         <td>${Carpeta.codigo_tip}</td>
                        <td class="text-center" width="20%"><a class="btnEditar btn btn-primary">Editar</a><a class="btnBorrar btn btn-danger">Borrar</a></td>
                    </tr>`
    })

    contenedor.innerHTML = resultados
}

//procedimiento mostrar registros
fetch(url1)
    .then(response => response.json())
    .then(data => mostrar(data))
    .catch(error => console.log(error))

const on = (element, event, selector, handler) => {
    element.addEventListener(event, e => {
        if (e.target.closest(selector))
            handler(e)
    })
}

on(document, 'click', '.btnBorrar', e => {
    const fila = e.target.parentNode.parentNode
    const id = fila.firstElementChild.innerHTML
    console.log(id)

    alertify.confirm("Desea eliminar el Carpeta "+id,
        function () {
            fetch(url + id, {
                method: 'DELETE'
            })
                .then(() => location.reload())
        },
        function () {
            alertify.error('Cancelado')
        });
})

let idForm = 0
on(document, 'click', '.btnEditar', e => {

    const fila = e.target.parentNode.parentNode
    
    idForm = fila.children[0].innerHTML
    const nombre = fila.children[1].innerHTML
    const identificacion = fila.children[2].innerHTML
    const codigo = fila.children[3].innerHTML
    idCarpeta.value = idForm
    idCarpeta.disabled = true
    nombreCarpeta.value = nombre
    identificacionCarpeta.value = identificacion
    codigoTipo.value = codigo


    opcion = 'editar'
    modalCarpetas.show()
})

formCarpetas.addEventListener('submit', (e) => {
    e.preventDefault()

        if (opcion == 'crear') {
            fetch(url, {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json'
                },
                body: JSON.stringify({
                    codigo_car: idCarpeta.value,
                    nombre_emp: nombreCarpeta.value,
                    identificacion_emp: identificacionCarpeta.value,
                    codigo_tip: codigoTipo.value
                })
            })
                .then(response => response.json())
                .then(data => {
                    const nuevoCarpeta = []
                    nuevoCarpeta.push(data)
                    mostrar(nuevoCarpeta)
                })
        }
        
        
        
        if (opcion == 'editar') {

            fetch(url, {
                method: 'PUT',
                headers: {
                    'Content-Type': 'application/json'
                },
                body: JSON.stringify({
                    codigo_car: idForm,
                    nombre_emp: nombreCarpeta.value,
                    identificacion_emp: identificacionCarpeta.value
                })
            })
                .then(response => location.reload())

        }
        modalCarpetas.hide()
    
})
