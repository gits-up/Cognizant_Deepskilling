import React from 'react';
import Cart from './Cart';

class OnlineShopping extends React.Component {
  render() {
    const cartItems = [
      { itemname: "Laptop", price: 80000 },
      { itemname: "TV", price: 120000 },
      { itemname: "Washing Machine", price: 50000 },
      { itemname: "Mobile", price: 30000 },
      { itemname: "Fridge", price: 70000 }
    ];

    return (
      <div style={{ textAlign: 'center' }}>
        <b><h2 style={{ color: 'green' }}>Items Ordered:</h2></b>
        <table
          border="1"
          cellPadding="10"
          style={{ color: 'green', margin: '0 auto' }}
        >
          <thead>
            <tr>
              <th>Item Name</th>
              <th>Price</th>
            </tr>
          </thead>
          <tbody>
            {cartItems.map((item, index) => (
              <Cart
                key={index}
                itemname={item.itemname}
                price={item.price}
              />
            ))}
          </tbody>
        </table>
      </div>
    );
  }
}

export default OnlineShopping;
