export const Relatorio = () => {
    return (
        <div className="space-y-6">
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