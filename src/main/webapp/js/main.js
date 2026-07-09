const input=document.getElementById("searchInput");

if(input){

input.addEventListener("keyup",()=>{

let filter=input.value.toLowerCase();

let rows=document.querySelectorAll("#patientTable tbody tr");

rows.forEach(r=>{

r.style.display=r.innerText.toLowerCase().includes(filter)?"":"none";

});

});

}
const doctorSearch = document.getElementById("searchDoctor");

if (doctorSearch) {

doctorSearch.addEventListener("keyup", () => {

let filter = doctorSearch.value.toLowerCase();

let rows = document.querySelectorAll("#doctorTable tbody tr");

rows.forEach(row => {

row.style.display =
row.innerText.toLowerCase().includes(filter)
? ""
: "none";

});

});

}
const appointmentSearch=document.getElementById("appointmentSearch");

if(appointmentSearch){

appointmentSearch.addEventListener("keyup",()=>{

let filter=appointmentSearch.value.toLowerCase();

let rows=document.querySelectorAll("#appointmentTable tbody tr");

rows.forEach(r=>{

r.style.display=r.innerText.toLowerCase().includes(filter)?"":"none";

});

});

}
document.addEventListener("DOMContentLoaded", function () {

    const today = new Date();

    const options = {
        weekday: 'long',
        day: 'numeric',
        month: 'long',
        year: 'numeric'
    };

    document.getElementById("currentDate").innerHTML =
        today.toLocaleDateString('en-IN', options);

});