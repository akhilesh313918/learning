const _id = document.querySelector('.u_id');
const _uname = document.querySelector('.u_name');
const _exp = document.querySelector('.u_exp');
const _sal = document.querySelector('.u_sal');
const _upddel = document.querySelector('.updatedel');




const createUser = async(empid,name,exp,sal)=> {
    let bodydata = {
        "empid": empid, 
        "exp":  exp,
        "name": name,
        "salary": sal
    };
    
    const options = {
        method: 'POST',
        headers: {
            'Content-Type' : 'application/json',
        },
        body: JSON.stringify(bodydata)
    };
    const url = 'http://localhost:8080/restapiapp/webapi/users/user';
    const response = await fetch(url, options);
    const data = await response.json();
    return data;
}

/*
createUser().then(data => {
    console.log(data);
}).catch(err => console.log(err));
*/


const updateUser = async(empid,name,exp,sal)=> {
    const bodydata = {
        "empid": empid,
        "exp": exp,
        "name": name,
        "salary": sal
    };
    
    const options = {
        method: 'PUT',
        headers: {
            'Content-Type' : 'application/json',
        },
        body: JSON.stringify(bodydata)
    };
    const url = 'http://localhost:8080/restapiapp/webapi/users/user/id';
    const response = await fetch(url, options);
    
}

/*
updateUser().then(() => {
    console.log("user updated");
}).catch(err => console.log(err));
*/


const deleteUser = async()=> {
    console.log("inside delete user");
    var usr = JSON.parse(sessionStorage.getItem('userObj2'));
    const bodydata = {
        empid: usr.u_id,
        exp: usr.u_exp,
        name: usr.u_name,
        salary: usr.u_sal
    };
    
    const options = {
        method: 'DELETE',
        headers: {
            'Content-Type' : 'application/json',
        },
        body: JSON.stringify(bodydata)
    };
    const url = 'http://localhost:8080/restapiapp/webapi/users/id';
    await fetch(url, options);
    sessionStorage.clear()
    window.document.location.reload();
    //const data = await response.json();
    //return data;
}
/*
deleteUser().then( () => {
    console.log("user deleted");
}).catch(err => console.log(err));
*/


const getUsers = async() => {
    const url =  'http://localhost:8080/restapiapp/webapi/users';
    const response = await fetch(url);
    const data = await response.json();
    //console.log(data);
    return data; 
}


getUsers().then(data => {
    data.forEach((value,i) => {
        //console.log(value,i);
        //console.log(value.empid,value.name,value.exp,value.salary);
        var userid =`<div class="border border-primary u_id_${i}">${value.empid}</div>`;
        var uname =`<div class="border border-primary u_uname_${i}">${value.name}</div>`;
        var uexp =`<div class="border border-primary u_exp_${i}">${value.exp}</div>`;
        var usal =`<div class="border border-primary u_sal_${i}">${value.salary}</div>`;
        var upddel =`<div class="border border-primary"><a href = "updateUser.html" class="btns" id=${i}>edit</a><span> / </span><a class="btns2" id=${i}>delete</a></div>`;
        /*<div>${value.name}</div>
        <div>${value.exp}</div>
        <div>${value.salary}</div>
        `;*/
        _id.innerHTML += userid;
        _uname.innerHTML += uname;
        _exp.innerHTML += uexp;
        _sal.innerHTML += usal;
        _upddel.innerHTML += upddel;
    });
    
    var items = document.querySelectorAll('.btns')
    var items2 = document.querySelectorAll('.btns2')
    console.log(items2);

    items.forEach(item => {
        console.log(item.name);
        item.addEventListener('click', e => {
            var val1 = e.target.id;
            console.log(val1);

            var userObj1 = {

                u_id: document.querySelector(`.u_id_${val1}`).innerHTML,
                u_name: document.querySelector(`.u_uname_${val1}`).innerHTML,
                u_exp: document.querySelector(`.u_exp_${val1}`).innerHTML,
                u_sal: document.querySelector(`.u_sal_${val1}`).innerHTML

            }

            sessionStorage.setItem('userObj1' , JSON.stringify(userObj1));
              
        }) 
    })


    items2.forEach(item => {
        console.log(item.name);
        item.addEventListener('click', e => {
            var val2 = e.target.id;
            console.log(val2);
            localStorage.setItem('userid' , val2);

            var userObj2 = {

                u_id: document.querySelector(`.u_id_${val2}`).innerHTML,
                u_name: document.querySelector(`.u_uname_${val2}`).innerHTML,
                u_exp: document.querySelector(`.u_exp_${val2}`).innerHTML,
                u_sal: document.querySelector(`.u_sal_${val2}`).innerHTML

            }

            sessionStorage.setItem('userObj2' , JSON.stringify(userObj2));
            deleteUser();
        })
    })

    }).catch(err => console.log(err));

