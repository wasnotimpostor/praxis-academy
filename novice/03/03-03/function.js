const makeNoise = function() {
    console.log("Pling!");
  };
  
  makeNoise();
  
  // const power = function(base, exponent) {
  //   let result = 1;
  //   for (let count = 0; count < exponent; count++) {
  //     result *= base;
  //   }
  //   return result;
  // };
  
  // console.log(power(2, 10));
  

  // Binding and Scopes
  let x = 10;
if (true) {
  let y = 20;
  var z = 30;
  console.log(x + y + z);
}
console.log(x + z);

const halve = function(n) {
    return n / 2;
  };
  
  let n = 10;
  console.log(halve(100));
  console.log(n);
  

  // nested scope
  const hummus = function(factor) {
    const ingredient = function(amount, unit, name) {
      let ingredientAmount = amount * factor;
      if (ingredientAmount > 1) {
        unit += "s";
      }
      console.log(`${ingredientAmount} ${unit} ${name}`);
    };
    ingredient(1, "can", "chickpeas");
    ingredient(0.25, "cup", "tahini");
    ingredient(0.25, "cup", "lemon juice");
    ingredient(1, "clove", "garlic");
    ingredient(2, "tablespoon", "olive oil");
    ingredient(0.5, "teaspoon", "cumin");
  };


  // functions as values
  // let launchMissiles = function() {
  //   missileSystem.launch("now");
  // };
  // if (safeMode) {
  //   launchMissiles = function() {/* do nothing */};
  // }

  // arrow function
  const power = (base, exponent) => {
    let result = 1;
    for (let count = 0; count < exponent; count++) {
      result *= base;
    }
    return result;
  };
  console.log(power(2,10));
  //contoh lainnya :
  // const square1 = (x) => { return x * x; };
  // const square2 = x => x * x;


  
  // the call stack
  function greet(who) {
    console.log("Hello " + who);
  }
  greet("Harry");
  console.log("Bye");