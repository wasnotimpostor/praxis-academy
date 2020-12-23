let ten = 10;
console.log(ten * ten);
// -> 100

let mood = "susah anjir";
console.log(mood);
// -> susah anjir
mood = "gampang";   // ketika isinya mood dirubah maka ketika di print akan mengikuti
console.log(mood);  // perubahan terakhirnya
// -> gampang

let coba = 140;
coba = coba - 20;       // sama kayak coba -= 20
console.log(coba);
// -> 120

let one = 1, two = 2;   // kalo lebih dari 1 pakai koma
console.log(one + two);
// -> 3

var name = "Evan";
const greeting = "Selamat pagi ";   // const itu tipe data final (tidak bisa dirubah)
console.log(greeting + name);
// -> Selamat pagi Evan

// function
prompt("Enter passcode"); // harusnya muncul pop up


// console.log function
let x = 30;
console.log("The value of x is ", x);
// -> The value of x is 30

// return values
console.log(Math.max(2,4));     // fungsi Math.max mengambil nilai terbesar
// -> 4

console.log(Math.min(2,4) + 100);     // fungsi Math.min mengambil nilai terkecil kemudian dijumlah 100
// -> 102

// control flow
let theNumber = Number(prompt("Pick a number"));    // muncul popup untuk input number
console.log("Your number is the square root of " + theNumber * theNumber);      // menampilkan hasil number kuadrat

// conditional execution
let theNamber = Namber(prompt("Pick a number"));
if(!Namber.isNaN(theNamber)) {      // fungsi isNaN untuk menguji apakah nilai dari parameter itu adalah string, kalau integer akan false, kalau string true
    console.log("Your number is the square root of " + theNamber * theNamber);  // kalau Namber isinya string, maka gak menampilkan apa2
} else {
    console.log("Kenapa bukan angka??")
}

let num = Angka(prompt("Masukkan angka"));
if(num < 10) {
    console.log("Small");
} else if(num < 100) {
    console.log("Medium");
} else {
    console.log("Large");
}

// while and do loops
console.log(0);
console.log(2);
console.log(4);
console.log(6);     // nulis ngene kesuwen gaes, looping wae

let looping = 0;
while (looping <= 6) {      // disetting kurang dari sama dengan 6 nilai loopingnya
    console.log(looping);   // menampilkan looping
    looping = looping + 2;  // nilai looping itu sendiri ditambah 2 terus sampai memenuhi syarat diatas
}

let result = 1;
let counter = 0;
while(counter < 10) {       // disetting nilai counter kurang dari 10
    result = result * 2;    // result dikali 2 dan disimpan nilai terbarunya
    counter = counter + 1;  // nilai counter start dari 1 & bertambah 1 terus menerus sampai syarat diatas terpenuhi
}
console.log(result);
// -> 1024

let yourName;       // variabel kosongan
do {
    yourName = prompt("Siapa namamu?");     // input nama
} while(!yourName);     // looping terus
console.log(yourName);

// for loops
for (let a = 0; a <= 12; a += 2) {
    console.log(a)
}