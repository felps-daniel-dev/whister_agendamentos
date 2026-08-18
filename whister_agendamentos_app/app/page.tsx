export default function Home() {
  return (
    <div className="space-y-6">
      
      {/* Cabeçalho */}
      <div className="flex flex-col sm:flex-row sm:items-center sm:justify-between gap-4">
        <div>
          <h1 className="text-2xl font-bold text-slate-900 tracking-tight">Painel Principal</h1>
          <p className="text-sm text-slate-500">Resumo geral das atividades de hoje.</p>
        </div>
        <div className="self-start sm:self-auto bg-white px-4 py-2 rounded-xl border border-slate-200/80 shadow-sm">
          <span className="text-xs font-semibold text-slate-600">Terça-Feira, 18 De Agosto De 2026</span>
        </div>
      </div>

      {/* Cards de Métricas */}
      <div className="grid grid-cols-1 sm:grid-cols-2 lg:grid-cols-4 gap-5">
        <div className="bg-white p-5 rounded-2xl border border-slate-200/70 shadow-sm flex flex-col justify-between h-32">
          <span className="text-2xl font-bold text-slate-800">12</span>
          <p className="text-xs font-medium text-slate-500">Consultas Hoje</p>
        </div>
        <div className="bg-white p-5 rounded-2xl border border-slate-200/70 shadow-sm flex flex-col justify-between h-32">
          <span className="text-2xl font-bold text-slate-800">48</span>
          <p className="text-xs font-medium text-slate-500">Pacientes Ativos</p>
        </div>
        <div className="bg-white p-5 rounded-2xl border border-slate-200/70 shadow-sm flex flex-col justify-between h-32">
          <span className="text-2xl font-bold text-slate-800">6</span>
          <p className="text-xs font-medium text-slate-500">Médicos em Serviço</p>
        </div>
        <div className="bg-white p-5 rounded-2xl border border-slate-200/70 shadow-sm flex flex-col justify-between h-32">
          <span className="text-2xl font-bold text-slate-800">6</span>
          <p className="text-xs font-medium text-slate-500">Salas Ocupadas</p>
        </div>
      </div>
    </div>
  );
}