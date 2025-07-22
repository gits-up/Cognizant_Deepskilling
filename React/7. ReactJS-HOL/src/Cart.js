import React from 'react';

class Cart extends React.Component {
  render() {
    return (
      <tr>
        <td>{this.props.itemname}</td>
        <td>{this.props.price}</td>
      </tr>
    );
  }
}

// Default props
Cart.defaultProps = {
  itemname: "No Item",
  price: 0
};

export default Cart;
