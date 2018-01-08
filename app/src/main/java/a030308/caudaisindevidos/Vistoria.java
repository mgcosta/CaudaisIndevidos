package a030308.caudaisindevidos;

/**
 * Created by marcia on 08-01-2018.
 */

public class Vistoria {

    protected int _id, createdBy;
    protected String rua, porta, localidade, clientePresente, crl, bombagem, tamponamento, anomalia, estado, ligado , fotos;


    public void setId(int id)
    {
        this._id = id;
    }

    public int getId()
    {
        return this._id;
    }

    public void setRua(String rua)
    {
        this.rua = rua;
    }

    public String getRua()
    {
        return this.rua;
    }

    public void setPorta(String porta)
    {
        this.porta = porta;
    }

    public String getPorta()
    {
        return this.porta;
    }

    public void setLocalidade(String localidade)
    {
        this.localidade = localidade;
    }

    public String getLocalidade()
    {
        return this.localidade;
    }

    public void setCrl(String crl)
    {
        this.crl = crl;
    }

    public String getCrl()
    {
        return this.crl;
    }

    public void setClientePresente(String clientePresente) {
        this.clientePresente = clientePresente;
    }

    public String getClientePresente()
    {
        return this.clientePresente;
    }

    public void setBombagem(String bombagem)
    {
        this.bombagem = bombagem;
    }

    public String getBombagem()
    {
        return this.bombagem;
    }


    public void setTamponamento(String tamponamento)
    {
        this.tamponamento = tamponamento;
    }

    public String getTamponamento()
    {
        return this.tamponamento;
    }

    public void setAnomalia(String anomalia)
    {
        this.anomalia = anomalia;
    }

    public String getAnomalia()
    {
        return this.anomalia;
    }

    public void setEstado(String estado)
    {
        this.estado = estado;
    }

    public String getEstado()
    {
        return this.estado;
    }

    public void setLigado(String ligado)
    {
        this.ligado = ligado;
    }

    public String getLigado()
    {
        return this.ligado;
    }

    public void setFotos(String fotos)
    {
        this.ligado = fotos;
    }

    public String getFotos()
    {
        return this.fotos;
    }


    public void setCreatedBy(Integer createdBy)
    {
        this.createdBy = createdBy;
    }

    public Integer getUserId()
    {
        return this.createdBy;
    }

}
