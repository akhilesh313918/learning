const userForm = document.querySelector('form');
const addbtn = document.querySelector('#add');
const empid = document.querySelector('#empid');
const fullname = document.querySelector('#fullname');
const exp = document.querySelector('#exp');
const sal = document.querySelector('#sal');

function add(){
addbtn.addEventListener('click' , () => {
    //e.preventDefault();
    console.log(empid.value, fullname.value, exp.value, sal.value );
    createUser(empid.value, fullname.value, exp.value, sal.value)
    .then(data => {
        console.log(data);
    })
})
};

function update(){
    userForm.addEventListener('submit' , e => {
        e.preventDefault();
        let empid = document.querySelector('#empid');
        let fullname = document.querySelector('#fullname');
        let exp = document.querySelector('#exp');
        let sal = document.querySelector('#sal');

        console.log(empid.value, fullname.value, exp.value, sal.value );
        updateUser(empid.value, fullname.value, exp.value, sal.value)
        .then(data => {
            console.log(data);
            alert("Details updated successfully.")
            location.replace("index.html");
        })
    });
}

function fillForm(){
    
    var x = JSON.parse(sessionStorage.getItem('userObj1'));
    var userid = `<label for="usrid">user id: </label>
    <input type="text" id="empid" value="${x.u_id}"><br>
    <label for="fname">Name: </label>
    <input type="text" id="fullname" value="${x.u_name}"><br>
    <label for="exp">Expeirence: </label>
    <input type="text" id="exp" value="${x.u_exp}"><br>
    <label for="sal">salary: </label>
    <input type="text" id="sal" value="${x.u_sal}"><br>
    <button type="submit" onclick="update()">update</button>  
    `;
    userForm.innerHTML += userid;
    }   

fillForm();
