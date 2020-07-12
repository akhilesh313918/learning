const userForm = document.querySelector('form');
const empid = document.querySelector('#empid');
const fullname = document.querySelector('#fullname');
const exp = document.querySelector('#exp');
const sal = document.querySelector('#sal');

function add(){
userForm.addEventListener('submit' , e => {
    e.preventDefault();
    console.log(empid.value, fullname.value, exp.value, sal.value);
    createUser(empid.value, fullname.value, exp.value, sal.value)
    .then(data => {
        console.log(data);
        window.document.location.reload();
        })
})
};