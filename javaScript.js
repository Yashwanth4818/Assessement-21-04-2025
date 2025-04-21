const countVowels = (str) => {
    const vowelPattern = [aeiou];
    const matches = str.match(vowelPattern); 
    return matches ? matches.length : 0; 
};

console.log(countVowels("Hello World")); 
