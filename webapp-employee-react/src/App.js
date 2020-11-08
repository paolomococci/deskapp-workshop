import './App.css';
import HeaderEmployeeComponent from './component/HeaderEmployeeComponent';
import MainEmployeeComponent from './component/MainEmployeeComponent';
import FooterEmployeeComponent from './component/FooterEmployeeComponent';

const App = () => {
  
  return (
    <div className="App">
      <HeaderEmployeeComponent/>
      <MainEmployeeComponent/>
      <FooterEmployeeComponent/>
    </div>
  );
}

export default App;
