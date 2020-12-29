let tri = ""
for (let i = 0; i < 6; i++){
    for (let j = 0; j < i; j++){   
        tri = tri + " #";
    }
    console.log(tri);
    tri = "";
}