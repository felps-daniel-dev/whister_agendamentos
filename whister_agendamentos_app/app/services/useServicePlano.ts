import { urlApi } from "./api";

const baseUrl = "/api/plano/listar";

export const useServicePlano = () => {
  const listarPlanos = async (): Promise<Plano[]> => {
    const response = await urlApi.get<Plano[]>(baseUrl);
    return response.data;
  };

  return {
    listarPlanos,
  };
};