
var tes = ""
for (let i = 1; i <= 5; i++) {
    for (let j = 1; j <= 5; j++) {       
        if ((i+j)%2 === 0) {
            tes = tes+" #";
            if(Math.round(5/2) == i && j == 5)
            tes = tes+""
        }
        else{
            tes = tes+" ";
        }
    }
    console.log(tes);
    tes = "";
}