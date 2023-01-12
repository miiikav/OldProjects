/**
 * Sort table rows alphabetically based on the values in a column
 *
 * @param {Number} col column index (zero based)
 * @param {HTMLTableElement} table the table to be sorted
 */

function sortTableByColumn(col, table) {
  // TODO: Implement this function
  let rows
  const tbody = table.getElementsByTagName('tbody');
  //console.log(tbody[0].getElementsByTagName(`tr`)[0].childElementCount);
  const colNum = tbody[0].getElementsByTagName(`tr`)[0].childElementCount-1;
    //make the array
    var i;
    for (i = 0; i <= colNum; i++) {
      if(col==i){
        rows = Array.from(tbody[0].getElementsByTagName(`tr`));
        // gets the right collumn for queryselector
        let qs = `td:nth-child(${col+1}`;
      
        //uses sort
        rows.sort( (r1,r2) => {
          let t1 = r1.querySelector(qs);
          let t2 = r2.querySelector(qs);
      
          //use localeCompare to compare values
          return t1.textContent.localeCompare(t2.textContent);
        });
      }
    }
    i=0;

  // Change values on the page
  rows.forEach(row => tbody[0].appendChild(row));
}

/**
 * DO NOT EDIT THE CODE BELOW!
 *
 * The code below is there just to make it easier to test the code.
 *
 * If your function works correctly you should be able to sort the table
 * simply by clicking any column heading and the table should be immediately
 * sorted by values in that column.
 */

// find the table element
const table = document.getElementById('sortable');

// attach an event listener to each th element's click event
table.querySelectorAll('thead th').forEach((th, i) =>
  th.addEventListener('click', () => {
    sortTableByColumn(i, table);
  })
);
