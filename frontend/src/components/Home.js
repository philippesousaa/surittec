import React from "react";
import { getAllClientes } from "../api/clientes";
import ClienteList from "./ClienteList";
import ProtectedComponent from "./ProtectedComponent";

class Home extends React.Component {
  state = {
    loading: true,
    listClients: [],
  };

  componentDidMount() {
    getAllClientes().then(res => this.setState({ listClients: res }));
  }

  deslogarUsuario = () => {
      localStorage.removeItem('tokenAuth')
      window.location.href = '/'
      }

  render() {
    const { listClients } = this.state;

    return (
      <div class="card card-clientes">
        <div className="card-header d-flex justify-content-between">
          <div>
            <h5>Clientes</h5>
          </div>
          <div className="d-flex justify-content-end">
            <ProtectedComponent allowedUsers={['admin']}>
              <div>
                <button className="btn btn-success mx-2" onClick={() => window.location.href =  "/createcliente"}>Adicionar</button>
              </div>
            </ProtectedComponent>

            <div>
              <button className="btn btn-danger" onClick={this.deslogarUsuario}>Deslogar</button>
            </div>
          </div>

        </div>

        <div class="Ccard-clientes-body">
          <ul class="list-group list-group-flush text-left">
            {listClients.map(c => (
              <ClienteList cliente={c} />
            ))}
          </ul>
        </div>
      </div>
    );
  }
}

export default Home;
